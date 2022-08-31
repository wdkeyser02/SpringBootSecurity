package willydekeyser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.cors().disable()
		.csrf().disable()
		.headers().frameOptions().disable()
		.and()
		.authorizeHttpRequests((authorize) -> authorize
				.mvcMatchers("/").permitAll()
				.mvcMatchers("*/h2-console/**").permitAll()
				.mvcMatchers("/user").hasAuthority("ROLE_USER")
				.mvcMatchers("/admin").hasAuthority("ROLE_ADMIN")
				.mvcMatchers("/moderator").hasAuthority("ROLE_MODERATOR")
				.anyRequest().denyAll()
		)
		.httpBasic()
		.and()
		.formLogin();
		return http.build();
	}
		
	@Bean
	MyUsersDetailsService myUsersDetailsService() {
		return new MyUsersDetailsService();
	}
	
	@Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
