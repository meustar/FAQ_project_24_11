package com.koreait.faq_project.repository;

import com.koreait.faq_project.entity.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestionRepository extends JpaRepository<UserQuestion, Long> {}