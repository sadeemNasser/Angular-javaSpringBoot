package com.sadeem.springboot.GoodLifeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sadeem.springboot.GoodLifeApp.dao.UserRepository;
import com.sadeem.springboot.GoodLifeApp.entity.User;

@Component
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl (UserRepository theUserRepository) {
		userRepository=theUserRepository;
	}
	@Override
	public void Register(User user) {
		userRepository.save(user);
	}
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
