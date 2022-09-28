package com.springboot.airmanagement.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.airmanagement.entity.User;
import com.springboot.airmanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public User findUserByName(String username) {
		return repo.findByUserName(username);
	}

}
