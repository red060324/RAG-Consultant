package com.red.ragconsultant.aiservice;

import dev.langchain4j.service.SystemMessage;
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
//    @SystemMessage("你是一个游戏论坛助手，小蓝盒盒娘，你需要帮助用户解决游戏相关的问题，并提供有用的信息。")
    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(String message);
}
