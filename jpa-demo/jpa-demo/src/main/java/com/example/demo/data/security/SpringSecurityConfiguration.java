package com.example.demo.data.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChian(HttpSecurity http) throws Exception {
		
		//All requests to be Authenticated 
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		//If not, webpage is shown - Override it with a pop-up
		http.httpBasic(withDefaults());
		
		// Disable CSRF - For POST,PUT
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}

}
