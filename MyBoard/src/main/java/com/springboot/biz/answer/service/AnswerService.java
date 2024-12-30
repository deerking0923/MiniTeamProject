package com.springboot.biz.answer.service;

import com.springboot.biz.answer.entity.AnswerEntity;
import com.springboot.biz.answer.dto.RequestAnswer;

import java.util.List;

public interface AnswerService {
    List<AnswerEntity> getAllAnswers();
    AnswerEntity getAnswerById(Integer id);
    AnswerEntity createAnswer(RequestAnswer requestAnswer);
    AnswerEntity updateAnswer(Integer id, RequestAnswer requestAnswer);
    void deleteAnswer(Integer id);
}
