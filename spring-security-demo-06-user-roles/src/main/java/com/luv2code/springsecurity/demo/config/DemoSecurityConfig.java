package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
				  .roles("MANAGER", "EMPLOYEE").build();
		
		UserDetails theAdmin = User.withUsername("Admin")
				  .password("{noop}test12345")
				  .roles("ADMIN", "EMPLOYEE").build();
		
		return new InMemoryUserDetailsManager(theUser, theManager, theAdmin);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(authorize -> authorize.antMatchers("/")
		.hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		)      
	    .formLogin(form -> form.loginPage("/showMyLoginPage")
	    .loginProcessingUrl("/authenticateTheUser")
	    .permitAll())
	    .logout()
	    .permitAll()
	    .and()
	    .exceptionHandling().accessDeniedPage("/access-denied");
		
		
	    
		return http.build();
	}
	
	
	
	
}
