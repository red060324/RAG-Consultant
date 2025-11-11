package com.red.ragconsultant.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * @author red
 * @date 2025/11/3
 * @description
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT, // 装配模式为显式装配
        chatModel = "openAiChatModel", // 使用名为 openAiChatModel 的聊天模型 bean
        streamingChatModel = "openAiStreamingChatModel", // 使用名为 openAiStreamingChatModel 的流式聊天模型 bean
//        chatMemory = "chatMemory", // 使用名为 chatMemory 的聊天记忆 bean
        chatMemoryProvider = "chatMemoryProvider", // 配置会话记忆提供者对象
        contentRetriever = "contentRetriever", // 向量数据库检索对象
        tools = "orderTool" // 工具方法所在的 bean 名称
)
public interface ConsultantService {
//    public String chat(String message);
//    @SystemMessage("你是一个游戏论坛助手，小蓝盒盒娘，你需要帮助用户解决游戏相关的问题，并提供有用的信息。")
    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}
