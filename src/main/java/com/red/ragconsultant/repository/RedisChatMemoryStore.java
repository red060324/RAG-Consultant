package com.red.ragconsultant.repository;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

/**
 * @author red
 * @date 2025/11/11
 * @description
 */
@Repository
public class RedisChatMemoryStore implements ChatMemoryStore {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        // 从 redis 中获取会话消息
        String json = redisTemplate.opsForValue().get(memoryId.toString());
        // json 转化为 list 并返回
        return ChatMessageDeserializer.messagesFromJson(json);

    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        // 更新会话消息
        // list 转化为 json
        String json = ChatMessageSerializer.messagesToJson(list);
        // 存储到 redis 中
        redisTemplate.opsForValue().set(memoryId.toString(), json, Duration.ofDays(1));
    }

    @Override
    public void deleteMessages(Object memoryId) {
        redisTemplate.delete(memoryId.toString());
    }
}
