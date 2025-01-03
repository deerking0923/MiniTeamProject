package com.springboot.biz.user.repository;

import com.springboot.biz.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}
