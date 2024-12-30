package com.springboot.biz.user.entity;

import com.springboot.biz.answer.entity.AnswerEntity;
import com.springboot.biz.question.entity.QuestionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private Set<QuestionEntity> questions;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private Set<AnswerEntity> answers;

    @ManyToMany(mappedBy = "voters")
    private Set<AnswerEntity> votedAnswers;
}
