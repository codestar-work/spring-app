package web;
import org.springframework.boot.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class Variable {
	@RequestMapping("/square")
	public int square(int n) {
		return n*n;
	}

	@RequestMapping("/area/{radius}")
	public double area(@PathVariable double radius) {
		return java.lang.Math.PI * radius * radius;
	}
}
