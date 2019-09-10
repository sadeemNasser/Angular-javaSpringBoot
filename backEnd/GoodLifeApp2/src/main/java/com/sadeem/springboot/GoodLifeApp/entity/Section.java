package com.sadeem.springboot.GoodLifeApp.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;



@Entity
@Table(name="SECTIONS")
@Data
public class Section {


	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SectionID")
	private int SectionID;
	
	@Column(name="SectionName")
	private String SectionName;
	//mappedBy = "GOAL",
	// هنا اشيل واحط @joincolomn mappedto 
	
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
	 @JoinColumn(name = "GoalSection",referencedColumnName = "SectionID")
	@OnDelete(action=OnDeleteAction.CASCADE)
	 private List<Goal> goals;
		
	


}




