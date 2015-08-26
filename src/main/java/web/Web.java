package web;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.annotation.*;
import javax.persistence.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import entity.*;

@Controller
public class Web {
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	@RequestMapping("*")
	String error() {
		return "error";
	}
	
	@RequestMapping("/list")
	String list(Model model) {
		Session database = factory.openSession();
		List list = database.createQuery("from Post").list();
		database.close();
		model.addAttribute("posts", list);
		return "list";
	}

	SessionFactory factory = new Configuration()
		.addPackage("entity")
		.addAnnotatedClass(Post.class)
		.addAnnotatedClass(User.class)
		.buildSessionFactory();
		
	@RequestMapping("/view/{id}")
	String view(Model model, @PathVariable long id) {
		Post post = new Post();
		Session database = factory.openSession();
		post = (Post)database.get(Post.class, id);
		database.close();
		model.addAttribute("post", post);
		return "view";
	}

	@RequestMapping("/login")
	String login(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	String login(HttpSession session, String email, String password) {
		Session database = factory.openSession();
		org.hibernate.Query query = database.createQuery(
			"from User where email = :email and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", encode(password));
		List list = query.list();
		
		if (list.size() == 1) {
			User user = (User)list.get(0);
			session.setAttribute("user", user);
			database.close();
			return "redirect:/post";
		} else {
			return "login";
		}
	}

	String encode(String s) {
		String result = "";
		try {
			java.security.MessageDigest digest = java.security.MessageDigest.
				getInstance("SHA-256");
			byte[] hash = digest.digest(s.getBytes("UTF-8"));
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					result += '0';
				result += hex;
			}
		} catch (Exception e) {}
		return result;
	}

	@RequestMapping("/logout")
	String logout(HttpSession session) {
		session.removeAttribute("email");
		session.invalidate();
		return "logout";
	}

	@RequestMapping("/post")
	String post(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/login";
		} else {
			return "post";
		}
	}
	
	@Value("${my.upload.path}")
	String uploadPath;

	@RequestMapping(value="/post", method=RequestMethod.POST)
	String post(HttpSession session, 
		String topic, String detail, MultipartFile file) {
		if (session.getAttribute("user") == null) {
			return "redirect:/login";
		} else {
			String name = "unknown.jpg";
			if (!file.isEmpty()) {
				String [] tokens = file.getOriginalFilename().split("\\.");
				String fileType = tokens[tokens.length - 1];
				name = UUID.randomUUID() + "." + fileType;
				try {
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(uploadPath + "/" + name)
					);
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {}	
			}
			User user = (User)session.getAttribute("user");
			Post post = new Post();
			post.setUser(user.getId());
			post.setTopic(topic);
			post.setDetail(detail);
			post.setFile(name);
			
			Session database = factory.openSession();
			database.save(post);
			database.flush();
			database.close();
			
			return "redirect:/list";
		}
	}
	
	@RequestMapping("/search-json") @ResponseBody
	List searchAjax(String search) {
		List list = new ArrayList();
		Session session = factory.openSession();
		org.hibernate.Query query = session.createQuery(
			"from Post where topic like :value or detail like :value");
		query.setParameter("value", "%" + search + "%");
		list = query.list();
		session.close();
		return list;
	}

	@RequestMapping("/list-jsp")
	String jsp(Model model) {
		Session database = factory.openSession();
		List list = database.createQuery("from Post").list();
		database.close();
		model.addAttribute("posts", list);
		return "list-jsp";
	}
	
	@RequestMapping("/list-angular")
	String viewAngular() {
		return "list-angular";
	}
	
}
