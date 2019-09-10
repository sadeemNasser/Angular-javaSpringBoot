package com.sadeem.springboot.GoodLifeApp.dao;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadeem.springboot.GoodLifeApp.entity.Goal;
import com.sadeem.springboot.GoodLifeApp.entity.GoalStatus;

public interface GoalRepository  extends JpaRepository<Goal,Integer>  {
	
	List<Goal> findByGoalSectionAndUserID(int userID, int GoalSection);
	
	List<Goal> findByUserID(int userId);
	
	Goal findByGoalIDAndUserID(int goalId,int userId);
	
	List<Goal> findByGoalSectionAndStatusAndUserID(int GoalSection,GoalStatus status,int userID);

}
