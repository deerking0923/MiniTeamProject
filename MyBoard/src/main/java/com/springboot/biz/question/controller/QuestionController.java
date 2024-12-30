package com.springboot.biz.question.controller;

import com.springboot.biz.question.dto.RequestQuestion;
import com.springboot.biz.question.dto.ResponseQuestion;
import com.springboot.biz.question.entity.QuestionEntity;
import com.springboot.biz.question.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<ResponseQuestion> getAllQuestions() {
        List<QuestionEntity> questions = questionService.getAllQuestions();
        return questions.stream()
                .map(question -> new ResponseQuestion(
                        question.getId(),
                        question.getTitle(),
                        question.getContent(),
                        question.getCreateDate(),
                        question.getModifyDate()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseQuestion getQuestionById(@PathVariable Integer id) {
        QuestionEntity question = questionService.getQuestionById(id);
        return new ResponseQuestion(
                question.getId(),
                question.getTitle(),
                question.getContent(),
                question.getCreateDate(),
                question.getModifyDate()
        );
    }

    @PostMapping
    public ResponseQuestion createQuestion(@RequestBody RequestQuestion request) {
        QuestionEntity question = questionService.createQuestion(request);
        return new ResponseQuestion(
                question.getId(),
                question.getTitle(),
                question.getContent(),
                question.getCreateDate(),
                question.getModifyDate()
        );
    }

    @PutMapping("/{id}")
    public ResponseQuestion updateQuestion(@PathVariable Integer id, @RequestBody RequestQuestion request) {
        QuestionEntity question = questionService.updateQuestion(id, request);
        return new ResponseQuestion(
                question.getId(),
                question.getTitle(),
                question.getContent(),
                question.getCreateDate(),
                question.getModifyDate()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
    }
}
