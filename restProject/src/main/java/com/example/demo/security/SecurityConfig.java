package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			
		return http.csrf(csrf -> csrf.disable())
//				.authorizeHttpRequests(
//						authorize -> authorize
//						.anyRequest().permitAll()
//						)
//				.authorizeHttpRequests(
//						authorize -> authorize
//						.anyRequest().authenticated()
//						)
				.authorizeHttpRequests(
						authorize -> authorize
//						.requestMatchers(HttpMethod.GET, "/user/{id}/blogs")
//						.permitAll()
						.requestMatchers(HttpMethod.POST, "/user")
						.permitAll()
						.requestMatchers(HttpMethod.PUT, "/user/**")
						.permitAll()
						.requestMatchers(HttpMethod.GET, "/user/**")
						.permitAll()
						
						
						.anyRequest().authenticated()
						)
				
				.httpBasic(withDefaults())
				.build();
		
	}
}

