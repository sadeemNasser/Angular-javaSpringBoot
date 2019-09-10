package com.sadeem.springboot.GoodLifeApp.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sadeem.springboot.GoodLifeApp.entity.User;


public interface UserRepository extends JpaRepository<User,Integer> {
	

	
	User findByEmail(String email);

}
