package com.springboot.biz.answer.service;

import com.springboot.biz.answer.entity.AnswerEntity;

public interface AnswerService {
    AnswerEntity getAnswerById(Long id); // 특정 Answer를 ID로 가져오는 메서드 정의
}
