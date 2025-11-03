package com.red.ragconsultant.aiservice;

import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

/**
 * @author red
 * @date 2025/11/3
 * @description
 */
@AiService
public interface ConsultantService {
//    public String chat(String message);
    public Flux<String> chat(String message);
}
