package com.red.ragconsultant.controller;

import com.red.ragconsultant.aiservice.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author red
 * @date 2025/11/3
 * @description
 */
@RestController
public class ChatController {

//    @Autowired
//    private OpenAiChatModel model;
//
//    @RequestMapping("/chat")
//    public String chat(String message) {
//        String result = model.chat(message);
//        return result;
//    }
    @Autowired
    private ConsultantService consultantService;

//    @RequestMapping("/chat")
//    public String chat(String message) {
//        return consultantService.chat(message);
//    }
    @RequestMapping(value = "/chat", produces = "text/html;charset=UTF-8")
    public Flux<String> chat(String memoryId, String message) {
        return consultantService.chat(memoryId, message);
    }

}
