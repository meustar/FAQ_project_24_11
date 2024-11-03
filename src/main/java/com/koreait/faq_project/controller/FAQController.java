package com.koreait.faq_project.controller;

import com.koreait.faq_project.service.OpenAiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FAQController {
    private final OpenAiService openAiService;

    public FAQController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @GetMapping("/ask")
    public String askForm() {
        return "ask";
    }

    @PostMapping("/ask")
    public String askQuestion(@RequestParam String question, Model model) {
        String answer = openAiService.getResponse(question).block(); // 비동기 Mono를 동기 방식으로 처리
        model.addAttribute("answer", answer);
        return "ask";
    }
}