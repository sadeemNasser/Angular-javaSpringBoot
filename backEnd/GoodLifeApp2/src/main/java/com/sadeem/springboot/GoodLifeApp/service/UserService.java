package com.sadeem.springboot.GoodLifeApp.service;

import com.sadeem.springboot.GoodLifeApp.entity.User;

public interface UserService {

	public void Register(User user);
	
	public User findByEmail(String email);
	
}
