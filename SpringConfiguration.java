package com.example.demo.Configuration;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService()	{
		UserDetails  user = User.withDefaultsPasswordEncoder()
				.username("Prajyot")
				.password("Pass@123")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz
				.requestMatchers("/message")
				//.anyRequest()
				.authenticated()
				)
				.httpBasic();
			return http.build();
		
	}
	}
