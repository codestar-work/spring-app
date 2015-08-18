package web;
import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class Demo {
	@RequestMapping("/hello")
	public String say() {
		return "Hello World!";
	}
}
