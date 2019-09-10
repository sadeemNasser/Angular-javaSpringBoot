package com.sadeem.springboot.GoodLifeApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadeem.springboot.GoodLifeApp.entity.Section;

public interface SectionRepository  extends JpaRepository<Section,Integer>  {

}
