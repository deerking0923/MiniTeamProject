package com.springboot.biz.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUser {
    private String username;
    private String password;
    private String email;
}
