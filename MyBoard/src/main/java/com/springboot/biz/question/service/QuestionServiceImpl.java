package com.springboot.biz.question.service;

import com.springboot.biz.exception.DataNotFoundException;
import com.springboot.biz.question.entity.QuestionEntity;
import com.springboot.biz.question.dto.RequestQuestion;
import com.springboot.biz.question.repository.QuestionRepository;
import com.springboot.biz.user.entity.UserEntity;
import com.springboot.biz.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public QuestionEntity getQuestionById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Question not found with id: " + id));
    }

    @Override
    public QuestionEntity createQuestion(RequestQuestion requestQuestion) {
        UserEntity author = userRepository.findById(requestQuestion.getAuthorId())
                .orElseThrow(() -> new DataNotFoundException("User not found with id: " + requestQuestion.getAuthorId()));

        QuestionEntity question = new QuestionEntity();
        question.setTitle(requestQuestion.getTitle());
        question.setContent(requestQuestion.getContent());
        question.setCreateDate(LocalDateTime.now());
        question.setAuthor(author);

        return questionRepository.save(question);
    }

    @Override
    public QuestionEntity updateQuestion(Integer id, RequestQuestion requestQuestion) {
        QuestionEntity question = getQuestionById(id);
        question.setTitle(requestQuestion.getTitle());
        question.setContent(requestQuestion.getContent());
        question.setModifyDate(LocalDateTime.now());

        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Integer id) {
        QuestionEntity question = getQuestionById(id);
        questionRepository.delete(question);
    }
}
