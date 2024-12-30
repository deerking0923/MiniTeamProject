package com.springboot.biz.question.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestQuestion {
    private String title;
    private String content;
    private Integer authorId;
}
