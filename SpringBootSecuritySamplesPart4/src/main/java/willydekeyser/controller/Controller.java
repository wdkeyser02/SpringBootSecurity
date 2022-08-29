package willydekeyser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String welkom() {
		return "Welkom";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welkom user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welkom admin";
	}
}