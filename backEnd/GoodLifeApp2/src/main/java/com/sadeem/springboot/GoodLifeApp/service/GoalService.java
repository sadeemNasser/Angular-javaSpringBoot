package com.sadeem.springboot.GoodLifeApp.service;

import java.util.List;

import com.sadeem.springboot.GoodLifeApp.entity.Goal;
import com.sadeem.springboot.GoodLifeApp.entity.GoalStatus;

public interface GoalService {


	public List<Goal> findByUser(int userId);
	
	public Goal findByGoalIDAndUserID(int goalId,int userId);
	
	public void addGoal(int userId,Goal theGoal);
	
	public void deleteById( int theId);
	
	public void MakeItDone(int userId,int theId);

	public void MakeItNotyet(int userId,int theId);

	public List<Goal> findBySection(int userId,int GoalSection);
	
	
	public List<Goal> findBySectionAndStatus(int userId,int GoalSection,GoalStatus status);


}
