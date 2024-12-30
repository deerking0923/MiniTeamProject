package com.springboot.biz.answer.service;

import com.springboot.biz.answer.entity.AnswerEntity;
import com.springboot.biz.answer.dto.RequestAnswer;
import com.springboot.biz.answer.repository.AnswerRepository;
import com.springboot.biz.exception.DataNotFoundException;
import com.springboot.biz.question.entity.QuestionEntity;
import com.springboot.biz.question.repository.QuestionRepository;
import com.springboot.biz.user.entity.UserEntity;
import com.springboot.biz.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AnswerEntity> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public AnswerEntity getAnswerById(Integer id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Answer not found with id: " + id));
    }

    @Override
    public AnswerEntity createAnswer(RequestAnswer requestAnswer) {
        QuestionEntity question = questionRepository.findById(requestAnswer.getQuestionId())
                .orElseThrow(() -> new DataNotFoundException("Question not found with id: " + requestAnswer.getQuestionId()));

        UserEntity author = userRepository.findById(requestAnswer.getAuthorId())
                .orElseThrow(() -> new DataNotFoundException("User not found with id: " + requestAnswer.getAuthorId()));

        AnswerEntity answer = new AnswerEntity();
        answer.setContent(requestAnswer.getContent());
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);

        return answerRepository.save(answer);
    }

    @Override
    public AnswerEntity updateAnswer(Integer id, RequestAnswer requestAnswer) {
        AnswerEntity answer = getAnswerById(id);
        answer.setContent(requestAnswer.getContent());
        answer.setModifyDate(LocalDateTime.now());
        return answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Integer id) {
        AnswerEntity answer = getAnswerById(id);
        answerRepository.delete(answer);
    }
}
