package com.koreait.faq_project.service;

import com.koreait.faq_project.openai.OpenAiRequest;
import com.koreait.faq_project.openai.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;


@Service
public class OpenAiService {
    private final WebClient webClient;

    public OpenAiService(@Value("${openai.url}") String url, @Value("${openai.api-key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public Mono<String> getResponse(String prompt) {
        OpenAiRequest request = new OpenAiRequest(prompt);

        return webClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OpenAiResponse.class)
                .map(OpenAiResponse::getAnswer)
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(2))
                        .filter(throwable -> throwable instanceof WebClientResponseException.TooManyRequests))
                .onErrorReturn("현재 요청이 너무 많습니다. 잠시 후 다시 시도해 주세요.");
    }
}
