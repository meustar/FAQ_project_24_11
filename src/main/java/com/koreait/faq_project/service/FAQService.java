package com.koreait.faq_project.service;

import com.koreait.faq_project.entity.FAQ;
import com.koreait.faq_project.repository.FAQRepository;
import com.koreait.faq_project.repository.UserQuestionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FAQService {
    private final FAQRepository faqRepository;
    private final UserQuestionRepository userQuestionRepository;
    private final OpenAiService openAiService;

    public FAQService(FAQRepository faqRepository, UserQuestionRepository userQuestionRepository, OpenAiService openAiService) {
        this.faqRepository = faqRepository;
        this.userQuestionRepository = userQuestionRepository;
        this.openAiService = openAiService;
    }

    public Mono<String> getAnswer(String question) {
        return Mono.justOrEmpty(faqRepository.findByQuestionContaining(question)
                        .map(FAQ::getAnswer))
                .switchIfEmpty(openAiService.getResponse(question));
    }
}
