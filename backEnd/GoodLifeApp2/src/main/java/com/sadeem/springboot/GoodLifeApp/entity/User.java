package com.sadeem.springboot.GoodLifeApp.entity;




import java.util.List;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;



@Entity
@Table(name="USERS")
@Data
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email",unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	//,mappedBy = "GOAL"
	// هنا اشيلmappedto واحط @joincolomn  
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
	 @JoinColumn(name = "UserID",referencedColumnName = "ID")
	@OnDelete(action=OnDeleteAction.CASCADE)
	 private List<Goal> goals;

//	@Transient
//	private String passwordConfirm;

	//@ManyToMany
	
	//private Set<Role> roles;
	

		
	


}
