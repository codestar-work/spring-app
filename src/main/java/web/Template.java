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
public class Template {
	
	@RequestMapping("/form-demo")
	String formDemo(String query) {
		System.out.println("NAME = " + query);
		return "form-demo";
	}

	@RequestMapping("/demo-freemarker")
	String freemarker() {
		return "demo-freemarker";
	}
	
	@RequestMapping("/demo-velocity")
	String velocity() {
		return "demo-velocity";
	}
	
	@RequestMapping("/demo-thymeleaf")
	String thymeleaf() {
		return "demo-thymeleaf";
	}
	
	@RequestMapping("/demo-mustache")
	String mustache() {
		return "demo-mustache";
	}
	
}
