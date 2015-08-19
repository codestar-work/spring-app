package web;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.*;
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
	SessionFactory factory = new Configuration()
		.addPackage("entity")
		.addAnnotatedClass(Post.class)
		.addAnnotatedClass(User.class)
		.buildSessionFactory();
		
	@RequestMapping("*")
	String error() {
		return "error";
	}

	@RequestMapping("/")
	String index(@ModelAttribute("model") ModelMap model) {
		List list = new ArrayList();
		try {
			Session database = factory.openSession();
			list = database.createQuery("from Post").list();
			database.close();
		} catch (Exception e) {}
		model.addAttribute("posts", list);
		return "index";
	}

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
	String login(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("email") == null) {
			return "login";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	String doLogin(HttpServletRequest request, String email, String password) {
		Session database = factory.openSession();
		org.hibernate.Query query = database.createQuery(
			"from User where email = :email and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", encode(password));
		List list = query.list();
		
		if (list.size() == 1) {
			User user = (User)list.get(0);
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("user", user);
			database.close();
			return "redirect:/post";
		} else {
			return "login";
		}
	}

	String encode(String s) {
		String result = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
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
	String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.removeAttribute("email");
		session.invalidate();
		return "logout";
	}

	@RequestMapping("/post")
	String post(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("email") == null) {
			return "redirect:/login";
		} else {
			return "post";
		}
	}

	@RequestMapping(value="/post", method=RequestMethod.POST)
	String postTopic(HttpServletRequest request, 
		String topic, String detail, MultipartFile file) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("email") == null) {
			return "redirect:/login";
		} else {
			String path = "src/main/resources/public/upload/";
			String name = "unknown.jpg";
			if (file.isEmpty()) {
			} else {
				name = UUID.randomUUID() + ".jpg";
				try {
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(path + name)
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
			database.beginTransaction();
			database.save(post);
			database.flush();
			database.getTransaction().commit();
			database.close();
			return "redirect:/";
		}
	}

}
