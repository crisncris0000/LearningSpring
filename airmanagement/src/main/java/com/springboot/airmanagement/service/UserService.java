package com.springboot.airmanagement.service;

import com.springboot.airmanagement.entity.User;

public interface UserService {

	public User findUserByName(String username);
	
}
