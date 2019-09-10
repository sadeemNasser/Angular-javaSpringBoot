package com.sadeem.springboot.GoodLifeApp.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadeem.springboot.GoodLifeApp.dao.GoalRepository;
import com.sadeem.springboot.GoodLifeApp.entity.Goal;
import com.sadeem.springboot.GoodLifeApp.entity.GoalStatus;

@Service
public class GoalServiceImpl implements GoalService {

	private GoalRepository goalRepository;
	
	@Autowired
	public GoalServiceImpl( GoalRepository theGoalRepository) {
		
		goalRepository=theGoalRepository;
	}

	@Override
	public Goal findByGoalIDAndUserID(int theId,int userId) {

		return goalRepository.findByGoalIDAndUserID(theId,userId);
		/*
		 * 
		Goal theGoal=null;
		if(result.isPresent()) 
			theGoal=result.get();
		}else {
			throw new RuntimeException("Didn't find the Goal Id - "+theId);
		}
		return theGoal;
		
		return theGoal;
		 */
	}

	@Override
	public void addGoal(int userId,Goal theGoal) {
		theGoal.setUserID(userId);
//		theGoal.setStatus(GoalStatus.NotYet);
		goalRepository.save(theGoal);
	}

	@Override
	public void deleteById(int theId) {
		goalRepository.deleteById(theId);

	}

	@Override
	public void MakeItDone(int userId,int theId) {
		Goal theGoal = goalRepository.findByGoalIDAndUserID(theId,userId);
		
		/*Goal theGoal=null;
		
		if(result.isPresent()) {
			theGoal=result.get();
		}else {
			throw new RuntimeException("Didn't find the Goal Id - "+theId);
		}*/
		 theGoal.setStatus(GoalStatus.Done);
		 goalRepository.save(theGoal);

	}

	@Override
	public void MakeItNotyet(int userId,int theId) {
		
		Goal theGoal = goalRepository.findByGoalIDAndUserID(theId,userId);
		/*
		Goal theGoal=null;
		
		if(result.isPresent()) {
			theGoal=result.get();
		}else {
			throw new RuntimeException("Didn't find the Goal Id - "+theId);
		}*/
		theGoal.setStatus(GoalStatus.NotYet);
		 goalRepository.save(theGoal);

		//goalRepository.findById(theId).setStatus(GoalStatus.NotYet);
	}
	@Override
	public List<Goal> findBySection(int userId,int theGoalSection) {

		List<Goal> result = goalRepository.findByGoalSectionAndUserID(theGoalSection,userId);

		return result;
	}
	@Override
	public List<Goal> findByUser(int userId) {

		List<Goal> result = goalRepository.findByUserID(userId);

		return result;
	}
	@Override
	public List<Goal> findBySectionAndStatus(int userId,int GoalSection,GoalStatus status) {
		
		List<Goal> result = goalRepository.findByGoalSectionAndStatusAndUserID(GoalSection, status,userId);
		
		return result;
	}

}
