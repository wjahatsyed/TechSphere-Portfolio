package com.wjahatsyed.portfolio.shopping_cart.service;

import com.wjahatsyed.portfolio.shopping_cart.model.Cart;
import com.wjahatsyed.portfolio.shopping_cart.model.CartItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.cart-events}")
    private String cartTopic;

    public CartService(RedisTemplate<String, Object> redisTemplate, KafkaTemplate<String, String> kafkaTemplate) {
        this.redisTemplate = redisTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Cart getCart(String userId) {
        return (Cart) redisTemplate.opsForValue().get(userId);
    }

    public void updateCart(String userId, CartItem item) {
        Cart cart = getCart(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
        }
        cart.addItem(item);
        redisTemplate.opsForValue().set(userId, cart);

        // Publish event to Kafka
        kafkaTemplate.send(cartTopic, "Cart updated for user: " + userId);
    }
}

