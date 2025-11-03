package com.red.ragconsultant.aiservice;

import dev.langchain4j.service.spring.AiService;

/**
 * @author red
 * @date 2025/11/3
 * @description
 */
@AiService
public interface ConsultantService {
    public String chat(String message);
}
