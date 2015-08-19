package web;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;

import entity.*;

@RestController
public class Hibernate {

	SessionFactory factory = new Configuration()
		.addPackage("entity")
		.addAnnotatedClass(Post.class)
		.addAnnotatedClass(User.class)
		.buildSessionFactory();
		
	@RequestMapping("/get-post/{id}")
	Post getPost(@PathVariable Long id) {
		Post post = new Post();
		Session session = factory.openSession();
		post = (Post)session.get(Post.class, id);
		session.close();
		return post;
	}

	@RequestMapping("/get-post-list")
	List getPostList() {
		List list = new ArrayList();
		Session session = factory.openSession();
		list = session.createQuery("from Post").list();
		session.close();
		return list;
	}
	
	@RequestMapping("/get-user/{id}")
	User getUser(@PathVariable Long id) {
		User user = new User();
		Session session = factory.openSession();
		user = (User)session.get(User.class, id);
		session.close();
		return user;
	}

	@RequestMapping("/get-user-list")
	List getUserList() {
		List list = new ArrayList();
		Session session = factory.openSession();
		org.hibernate.Query query = session.createQuery(
			"from User where email = :email");
		query.setParameter("email", "user@codestar.work");
		list = query.list();
		session.close();
		return list;
	}
}
