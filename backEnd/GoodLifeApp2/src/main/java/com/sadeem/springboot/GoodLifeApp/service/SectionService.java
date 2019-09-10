package com.sadeem.springboot.GoodLifeApp.service;

import java.util.List;


import com.sadeem.springboot.GoodLifeApp.entity.Section;

public interface SectionService {

	public List<Section> findAll();

	public void addSection(Section theSection);
	
	public void deleteById(int theId);

	public Section findById(int sectionId);


}
