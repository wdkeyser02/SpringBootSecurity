package willydekeyser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String index() {
		return "<h1>Welkom</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welkom User</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welkom Admin</h1>";
	}
	
	@GetMapping("/moderator")
	public String moderator() {
		return "<h1>Welkom Moderator</h1>";
	}
	
	@GetMapping("/denyall")
	public String denyAll() {
		return "<h1>Deny For All!</h1>";
	}
}
