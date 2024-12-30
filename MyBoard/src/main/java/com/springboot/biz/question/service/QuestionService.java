package com.springboot.biz.question.service;

import com.springboot.biz.question.entity.QuestionEntity;
import com.springboot.biz.question.dto.RequestQuestion;

import java.util.List;

public interface QuestionService {
    List<QuestionEntity> getAllQuestions();
    QuestionEntity getQuestionById(Integer id);
    QuestionEntity createQuestion(RequestQuestion requestQuestion);
    QuestionEntity updateQuestion(Integer id, RequestQuestion requestQuestion);
    void deleteQuestion(Integer id);
}
