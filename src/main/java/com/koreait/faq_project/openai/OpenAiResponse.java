package com.koreait.faq_project.openai;

import lombok.Data;

import java.util.List;


@Data
public class OpenAiResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private Message message;
    }

    @Data
    public static class Message {
        private String content;
    }

    public String getAnswer() {
        return choices != null && !choices.isEmpty() ? choices.get(0).getMessage().getContent().trim() : "No answer available";
    }
}