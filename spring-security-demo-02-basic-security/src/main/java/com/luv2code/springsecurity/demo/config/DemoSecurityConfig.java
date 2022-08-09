package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig{

	@Bean
	public InMemoryUserDetailsManager configure() {
		UserDetails theUser = User.withUsername("John")
							  .password("{noop}test123")
							  .roles("EMPLOYEE").build();
		
		
		UserDetails theManager = User.withUsername("Billy")
				  .password("{noop}test1234")
				  .roles("MANAGER").build();
		
		UserDetails theAdmin = User.withUsername("Admin")
				  .password("{noop}test12345")
				  .roles("ADMIN").build();
		
		return new InMemoryUserDetailsManager(theUser, theManager, theAdmin);
	}
	
	
	
	
	
	
}
