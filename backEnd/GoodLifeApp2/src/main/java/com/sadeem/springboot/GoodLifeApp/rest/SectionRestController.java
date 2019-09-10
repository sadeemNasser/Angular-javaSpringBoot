package com.sadeem.springboot.GoodLifeApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sadeem.springboot.GoodLifeApp.entity.Section;
import com.sadeem.springboot.GoodLifeApp.service.SectionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SectionRestController {


		private SectionService sectionService;
		
		@Autowired
		public SectionRestController(SectionService theSectionService) {
			sectionService=theSectionService;
		}
		
		
		@GetMapping("/sections")
		public List<Section> findAll(){
			return sectionService.findAll();
		}
		@PostMapping("/sections")
		public Section addSection(@RequestBody Section theSection) {
			
			theSection.setSectionID(0);
			sectionService.addSection(theSection);
			
			return theSection;
		}
		@DeleteMapping("/sections/{sectionId}")
		public ResponseEntity<String> DeleteSection(@PathVariable int sectionId) {
			
			Section theSection=sectionService.findById(sectionId);
			
			if(theSection==null)
				return new ResponseEntity<String>("Section ID not found-"+sectionId,HttpStatus.NOT_FOUND);
			
			sectionService.deleteById(sectionId);
			
			return new ResponseEntity<String>("deleted section id -"+sectionId,HttpStatus.ACCEPTED);
		}
		/*
		 * 
		 * */
}

