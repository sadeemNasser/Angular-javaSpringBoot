package com.sadeem.springboot.GoodLifeApp.rest;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sadeem.springboot.GoodLifeApp.entity.Goal;
import com.sadeem.springboot.GoodLifeApp.entity.GoalStatus;
import com.sadeem.springboot.GoodLifeApp.service.GoalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GoalRestController {


	private GoalService goalService;
	
	@Autowired
	public GoalRestController(GoalService theGoalService) {
		
		goalService=theGoalService;
		
	}
	
	//return goal by Section GET/goals/{SectionId}
	@GetMapping("/{userId}/goals")
	public ResponseEntity<?> getGoalsByUser(@PathVariable int userId) {
		
		
		List<Goal>  theGoal=goalService.findByUser(userId);
		
		if(theGoal.size()==0)
			return new ResponseEntity<String>("Goals not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Goal>>(theGoal,HttpStatus.ACCEPTED);	
		}
	//return goal by goalId GET/goals/{goalId}
	@GetMapping("/{userId}/goals/{goalId}")
	public ResponseEntity<?> getGoal(@PathVariable int goalId,@PathVariable int userId) {
		
		
		Goal theGoal=goalService.findByGoalIDAndUserID(goalId,userId);
		
		if(theGoal==null)
		return new ResponseEntity<String>("Goal ID not found-"+goalId,HttpStatus.NOT_FOUND);
		//throw new RuntimeException("Goal ID not found-"+goalId);

		
		//return theGoal;
		return new ResponseEntity<Goal>(theGoal,HttpStatus.ACCEPTED);

	}
	
	//return goal by Section GET/goals/{SectionId}
	@GetMapping("/{userId}/goals/section={sectionId}")
	public ResponseEntity<?> getGoalsBySection(@PathVariable int sectionId,@PathVariable int userId) {
		
		
		List<Goal>  theGoal=goalService.findBySection(userId,sectionId);
		
		if(theGoal.size()==0)
			return new ResponseEntity<String>("Goals Not found for Section ID - "+sectionId,HttpStatus.NOT_FOUND);
			//throw new RuntimeException("Goals Not found for Section ID - "+sectionId);
		
		//return theGoal;
		return new ResponseEntity<List<Goal>>(theGoal,HttpStatus.ACCEPTED);

		
	}
	

	
	//add Goal
	@PostMapping("/{userId}/goals")
	public ResponseEntity<String> addGoal(@RequestBody Goal theGoal,@PathVariable int userId) {
		
		theGoal.setGoalID(0);
//		theGoal.setStatus(GoalStatus.NotYet);
		theGoal.setUserID(userId);
		goalService.addGoal(userId,theGoal);
		
		return new ResponseEntity<String>("Goal was added successfuly",HttpStatus.ACCEPTED);	}
	
	//update Goal
	@PutMapping("/{userId}/goals")
	public ResponseEntity<String> UpdateGoal(@RequestBody Goal theGoal ,@PathVariable int userId) {
		 Goal goal=goalService.findByGoalIDAndUserID(theGoal.getGoalID(),userId);
			
		if(goal==null)
			return new ResponseEntity<String>("Goal not found to update",HttpStatus.NOT_FOUND);
		 
//		theGoal.setStatus(GoalStatus.NotYet);
		goalService.addGoal(userId,theGoal);
		
		return new ResponseEntity<String>("Goal was updated",HttpStatus.ACCEPTED);
	}
	
	//delete goal by goalId 
	@DeleteMapping("/{userId}/goals/{goalId}")
	public ResponseEntity<String> DeleteGoal(@PathVariable int goalId,@PathVariable int userId) {
		
		Goal theGoal=goalService.findByGoalIDAndUserID(goalId,userId);
		
		if(theGoal==null) {
			return new ResponseEntity<String>("Goal ID not found-"+goalId,HttpStatus.NOT_FOUND);
		}
		goalService.deleteById(goalId);
		
		return new ResponseEntity<String>("deleted goal id-"+goalId,HttpStatus.ACCEPTED);
	}
	
	
	//NotYet status Goal
	
	
		@PutMapping("/{userId}/goals/{goalId}/Notyet")
		public ResponseEntity<String> GoalNotyet(@PathVariable int goalId,@PathVariable int userId) {

			Goal theGoal=goalService.findByGoalIDAndUserID(goalId,userId);
			
			if(theGoal==null)
				return new ResponseEntity<String>("Goal ID not found-"+goalId,HttpStatus.NOT_FOUND);
			
			goalService.MakeItNotyet(userId,goalId);
			
			return new ResponseEntity<String>("Notyet status of goal id -"+goalId,HttpStatus.ACCEPTED);
		}
		
		
		//NotYet status Goal
		
		@PutMapping("/{userId}/goals/{goalId}/Done")
		public ResponseEntity<String> GoalDone(@PathVariable int goalId,@PathVariable int userId) {

			Goal theGoal=goalService.findByGoalIDAndUserID(goalId,userId);
			
			if(theGoal==null)
				return new ResponseEntity<String>("Goal ID not found-"+goalId,HttpStatus.NOT_FOUND);
			
			goalService.MakeItDone(userId,goalId);
			return new ResponseEntity<String>("Done status of goal id ->"+goalId,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/{userId}/goals/section={sectionId}/Notyet")
		public ResponseEntity<?> getGoalBySectionAndNotyetStatus(@PathVariable int sectionId,@PathVariable int userId ) {
			
			List<Goal> theGoal=goalService.findBySectionAndStatus(userId,sectionId, GoalStatus.NotYet);
			if(theGoal.size()==0)
				return new ResponseEntity<String>("Goal not found sectionId-"+sectionId+", status - "+GoalStatus.NotYet,HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<List<Goal>>(theGoal,HttpStatus.ACCEPTED);
		}
		@GetMapping("/{userId}/goals/section={sectionId}/Done")
		public ResponseEntity<?> getGoalBySectionAndDonetStatus(@PathVariable int sectionId ,@PathVariable int userId ) {
			
			List<Goal> theGoal=goalService.findBySectionAndStatus(userId,sectionId, GoalStatus.Done);
			
			if(theGoal.size()==0)
				return new ResponseEntity<String>("Goal not found sectionId-"+sectionId+", status - "+GoalStatus.Done,HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<List<Goal>>(theGoal,HttpStatus.ACCEPTED);
		}
	
}
