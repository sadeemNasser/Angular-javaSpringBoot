package com.sadeem.springboot.GoodLifeApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sadeem.springboot.GoodLifeApp.dao.SectionRepository;
import com.sadeem.springboot.GoodLifeApp.entity.Section;

@Component
public class SectionServiceImpl implements SectionService {

	private SectionRepository sectionRepository;
	
	@Autowired
	public SectionServiceImpl(SectionRepository theSectionRepository) {
		sectionRepository=theSectionRepository;
	}

	@Override
	public void addSection(Section theSection) {
		sectionRepository.save(theSection);
	}

	@Override
	public List<Section> findAll() {

		return sectionRepository.findAll();

	}

	@Override
	public void deleteById(int theId) {
		sectionRepository.deleteById(theId);		
	}

	@Override
	public Section findById(int sectionId) {

		Optional<Section> result = sectionRepository.findById(sectionId);
		
		Section theSection=null;
		
		if(result.isPresent()) {
			theSection=result.get();
		}else {
			throw new RuntimeException("Didn't find the Section Id - "+sectionId);
		}
		return theSection;
	}

}
