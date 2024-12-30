package com.springboot.biz.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseUser {
    private Integer id;
    private String username;
    private String email;
}
