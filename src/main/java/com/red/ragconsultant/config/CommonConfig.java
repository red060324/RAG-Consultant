package com.red.ragconsultant.config;

import com.red.ragconsultant.aiservice.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author red
 * @date 2025/11/3
 * @description
 */
@Configuration
public class CommonConfig {
    @Autowired
    private OpenAiChatModel model;

//    @Bean
//    public ConsultantService consultantService(){
//        return AiServices.builder(ConsultantService.class)
//                .chatLanguageModel(model)
//                .build();
//    }
}
