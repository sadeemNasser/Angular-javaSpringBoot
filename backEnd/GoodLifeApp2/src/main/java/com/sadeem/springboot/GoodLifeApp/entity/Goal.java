package com.sadeem.springboot.GoodLifeApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="GOALS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GoalID")
	private int goalID;
	
	@Column(name="GoalName")
	private String goalName;
	
	@Column(name="Description")
	private String description;
	// اشيلها واعرف متغير عادي عن طريق @column 
	/*
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name="UserID")
	 @JsonIgnore
	 private USER user;
	 */
	 @Column(name = "UserID")
	 private int userID;
	 /*
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="GoalSection")
	 @JsonIgnore
	 private SECTION section; 
	 */
	 @Column(name = "GoalSection")
	 private int goalSection;
	 
	 @Column(updatable = true,name="status" )
	 @Enumerated(EnumType.ORDINAL)
	 private GoalStatus status=GoalStatus.NotYet;


		

		

	 


}


