package com.springboot.biz.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.biz.answer.entity.AnswerEntity;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer> {

}
