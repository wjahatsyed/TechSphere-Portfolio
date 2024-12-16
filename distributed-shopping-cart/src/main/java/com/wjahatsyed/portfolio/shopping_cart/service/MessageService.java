package com.wjahatsyed.portfolio.shopping_cart.service;


import com.wjahatsyed.portfolio.shopping_cart.model.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final RedisTemplate<String, Object> redisTemplate;

    public MessageService(KafkaTemplate<String, String> kafkaTemplate, RedisTemplate<String, Object> redisTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.redisTemplate = redisTemplate;
    }

    public void sendMessageToKafka(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void saveMessageToRedis(String key, Message message) {
        redisTemplate.opsForValue().set(key, message);
    }

    public Message getMessageFromRedis(String key) {
        return (Message) redisTemplate.opsForValue().get(key);
    }
}

