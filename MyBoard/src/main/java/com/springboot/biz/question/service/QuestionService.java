package com.springboot.biz.question.service;

import com.springboot.biz.question.entity.QuestionEntity;
import java.util.List;

public interface QuestionService {
    // 1. 모든 질문 조회
    List<QuestionEntity> getAllQuestions();

    // 2. ID로 특정 질문 조회
    QuestionEntity getQuestionById(Long id);

    // 3. 새로운 질문 생성
    QuestionEntity createQuestion(QuestionEntity question);

    // 4. 질문 업데이트
    QuestionEntity updateQuestion(Long id, QuestionEntity question);

    // 5. 질문 삭제
    void deleteQuestion(Long id);
}
