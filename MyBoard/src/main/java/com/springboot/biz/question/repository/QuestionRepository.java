package com.springboot.biz.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.biz.question.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
	
	
}
