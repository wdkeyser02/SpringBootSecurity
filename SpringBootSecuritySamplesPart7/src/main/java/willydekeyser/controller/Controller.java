package willydekeyser.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Authorities;
import willydekeyser.model.Users;
import willydekeyser.repository.AuthoritiesRepository;
import willydekeyser.repository.UsersRepository;

@RestController
@RequiredArgsConstructor
public class Controller {

	private final UsersRepository usersRepository;
	private final AuthoritiesRepository authoritiesRepository;
	
	@GetMapping("/")
	public ResponseEntity<String> index() {
		String response = """ 
				<h1>Welcome</h1>
				<h2>Endpoint: index</h2>
				<p><a href='/user'>user</a></p>
				<p><a href='/admin'>admin</a></p>
				<p><a href='/moderator'>moderator</a></p>
				<p><a href='/users'>users</a></p>
				<p><a href='/authorities'>authorities</a></p>
				<p><a href='/h2-console'>H2 console</a></p>
				<p><a href='/logout'>Logout</a></p>
				""";			
		return ResponseEntity.ok().body(response);
		//return "<h1>Welkom</h1>";
	}
	
	@GetMapping("/user")
	public ResponseEntity<String> user(Authentication authentication) {
		String response = """ 
				<h1>Welcome</h1>
				<h2>Endpoint: user</h2>
				<p>User: %s</p>
				<p>Authorities: %s</p>
				""".formatted(authentication.getName(), authentication.getAuthorities());			
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin(Authentication authentication) {
		String response = """ 
				<h1>Welcome</h1>
				<h2>Endpoint: admin</h2>
				<p>User: %s</p>
				<p>Authorities: %s</p>
				""".formatted(authentication.getName(), authentication.getAuthorities());			
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/moderator")
	public ResponseEntity<String> moderator(Authentication authentication) {
		String response = """ 
				<h1>Welcome</h1>
				<h2>Endpoint: moderator</h2>
				<p>User: %s</p>
				<p>Authorities: %s</p>
				""".formatted(authentication.getName(), authentication.getAuthorities());			
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>> userList() {
		return ResponseEntity.ok().body(usersRepository.findAll());
	}
	
	@GetMapping("/authorities")
	public ResponseEntity<List<Authorities>> authoritiesList() {
		return ResponseEntity.ok().body(authoritiesRepository.findAll());
	}

	@GetMapping("/denyall")
	public String denyAll() {
		return "<h1>Deny For All!</h1>";
	}
}
