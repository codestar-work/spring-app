package web;
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
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import entity.*;

@Controller
public class Template {
	
	@RequestMapping("/demo-jsp")
	String jsp() {
		return "demo-jsp";
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