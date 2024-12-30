package com.springboot.biz.answer.controller;

import com.springboot.biz.answer.dto.RequestAnswer;
import com.springboot.biz.answer.dto.ResponseAnswer;
import com.springboot.biz.answer.entity.AnswerEntity;
import com.springboot.biz.answer.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public List<ResponseAnswer> getAllAnswers() {
        List<AnswerEntity> answers = answerService.getAllAnswers();
        return answers.stream()
                .map(answer -> new ResponseAnswer(answer.getId(), answer.getContent(), answer.getCreateDate(), answer.getModifyDate()))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseAnswer getAnswerById(@PathVariable Integer id) {
        AnswerEntity answer = answerService.getAnswerById(id);
        return new ResponseAnswer(answer.getId(), answer.getContent(), answer.getCreateDate(), answer.getModifyDate());
    }

    @PostMapping
    public ResponseAnswer createAnswer(@RequestBody RequestAnswer request) {
        AnswerEntity answer = answerService.createAnswer(request);
        return new ResponseAnswer(answer.getId(), answer.getContent(), answer.getCreateDate(), answer.getModifyDate());
    }

    @PutMapping("/{id}")
    public ResponseAnswer updateAnswer(@PathVariable Integer id, @RequestBody RequestAnswer request) {
        AnswerEntity answer = answerService.updateAnswer(id, request);
        return new ResponseAnswer(answer.getId(), answer.getContent(), answer.getCreateDate(), answer.getModifyDate());
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Integer id) {
        answerService.deleteAnswer(id);
    }
}
