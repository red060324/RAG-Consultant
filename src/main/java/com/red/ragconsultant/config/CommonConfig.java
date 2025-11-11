package com.red.ragconsultant.config;

import com.red.ragconsultant.aiservice.ConsultantService;
import com.red.ragconsultant.repository.RedisChatMemoryStore;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
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
    @Autowired
    private RedisChatMemoryStore redisChatMemoryStore;

//    @Bean
//    public ConsultantService consultantService(){
//        return AiServices.builder(ConsultantService.class)
//                .chatLanguageModel(model)
//                .build();
//    }

    // 配置会话记忆对象
    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder()
                .maxMessages(20)
                .build();
    }

    // 构建 ChatMemoryProvider 对象
    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return new ChatMemoryProvider() {
            @Override
            public ChatMemory get(Object memoryId) {
                return MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .maxMessages(20)
                        .chatMemoryStore(redisChatMemoryStore)
                        .build();
            }
        };
    }

}
