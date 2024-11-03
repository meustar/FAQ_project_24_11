package com.koreait.faq_project.openai;

import lombok.Data;

import java.util.List;

@Data
public class OpenAiRequest {
    private final String model = "gpt-3.5-turbo"; // 모델 이름
    private final List<Message> messages;

    public OpenAiRequest(String prompt) {
        this.messages = List.of(new Message("user", prompt));
    }

    @Data
    public static class Message {
        private final String role;
        private final String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}