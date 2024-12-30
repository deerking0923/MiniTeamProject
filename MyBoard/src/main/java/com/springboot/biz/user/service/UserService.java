package com.springboot.biz.user.service;

import com.springboot.biz.user.entity.UserEntity;
import com.springboot.biz.user.dto.RequestUser;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Integer id);
    UserEntity getUserByUsername(String username);
    UserEntity createUser(RequestUser requestUser);
    UserEntity updateUser(Integer id, RequestUser requestUser);
    void deleteUser(Integer id);
}
