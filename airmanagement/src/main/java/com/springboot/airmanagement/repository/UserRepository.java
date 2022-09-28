package com.springboot.airmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.airmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUserName(String username);
	
}
