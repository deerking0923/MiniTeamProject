package com.springboot.biz.answer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAnswer {
    private String content;
    private Integer questionId;
    private Integer authorId;
}
