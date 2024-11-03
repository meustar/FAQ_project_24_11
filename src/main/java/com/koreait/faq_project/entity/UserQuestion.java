package com.koreait.faq_project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class UserQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column
    private String answer;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}