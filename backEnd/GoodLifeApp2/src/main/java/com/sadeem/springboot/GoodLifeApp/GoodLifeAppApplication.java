package com.sadeem.springboot.GoodLifeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.sadeem.springboot.GoodLifeApp"})
//@EnableJpaRepositories("com.sadeem.springboot.GoodLifeApp.dao")
public class GoodLifeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodLifeAppApplication.class, args);
	}
}
