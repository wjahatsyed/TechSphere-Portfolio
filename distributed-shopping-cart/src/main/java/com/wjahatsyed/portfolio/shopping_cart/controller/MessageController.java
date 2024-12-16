package com.wjahatsyed.portfolio.shopping_cart.controller;

import com.wjahatsyed.portfolio.shopping_cart.model.Message;
import com.wjahatsyed.portfolio.shopping_cart.service.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/kafka")
    public String sendMessageToKafka(@RequestBody String message) {
        messageService.sendMessageToKafka("message-topic", message);
        return "Message sent to Kafka successfully.";
    }

    @PostMapping("/redis")
    public String saveMessageToRedis(@RequestParam String key, @RequestBody Message message) {
        messageService.saveMessageToRedis(key, message);
        return "Message saved to Redis successfully.";
    }

    @GetMapping("/redis")
    public Message getMessageFromRedis(@RequestParam String key) {
        return messageService.getMessageFromRedis(key);
    }
}
