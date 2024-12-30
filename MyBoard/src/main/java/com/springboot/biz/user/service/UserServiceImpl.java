package com.springboot.biz.user.service;

import com.springboot.biz.exception.DataNotFoundException;
import com.springboot.biz.user.entity.UserEntity;
import com.springboot.biz.user.dto.RequestUser;
import com.springboot.biz.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User not found with id: " + id));
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity createUser(RequestUser requestUser) {
        UserEntity user = new UserEntity();
        user.setUsername(requestUser.getUsername());
        user.setPassword(requestUser.getPassword()); // 실제로는 암호화를 적용해야 합니다.
        user.setEmail(requestUser.getEmail());
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(Integer id, RequestUser requestUser) {
        UserEntity user = getUserById(id);
        user.setUsername(requestUser.getUsername());
        user.setPassword(requestUser.getPassword()); // 실제로는 암호화를 적용해야 합니다.
        user.setEmail(requestUser.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        UserEntity user = getUserById(id);
        userRepository.delete(user);
    }
}
