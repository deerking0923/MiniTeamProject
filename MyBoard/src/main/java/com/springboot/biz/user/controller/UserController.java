package com.springboot.biz.user.controller;

import com.springboot.biz.user.dto.RequestUser;
import com.springboot.biz.user.dto.ResponseUser;
import com.springboot.biz.user.entity.UserEntity;
import com.springboot.biz.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<ResponseUser> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return users.stream()
                .map(user -> new ResponseUser(user.getId(), user.getUsername(), user.getEmail()))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseUser getUserById(@PathVariable Integer id) {
        UserEntity user = userService.getUserById(id);
        return new ResponseUser(user.getId(), user.getUsername(), user.getEmail());
    }

    @PostMapping
    public ResponseUser createUser(@RequestBody RequestUser request) {
        UserEntity user = userService.createUser(request);
        return new ResponseUser(user.getId(), user.getUsername(), user.getEmail());
    }

    @PutMapping("/{id}")
    public ResponseUser updateUser(@PathVariable Integer id, @RequestBody RequestUser request) {
        UserEntity user = userService.updateUser(id, request);
        return new ResponseUser(user.getId(), user.getUsername(), user.getEmail());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
