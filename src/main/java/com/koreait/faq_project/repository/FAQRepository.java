package com.koreait.faq_project.repository;

import com.koreait.faq_project.entity.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
    Optional<FAQ> findByQuestionContaining(String question);
}