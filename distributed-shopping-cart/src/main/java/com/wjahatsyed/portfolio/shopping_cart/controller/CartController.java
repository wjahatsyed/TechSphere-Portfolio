package com.wjahatsyed.portfolio.shopping_cart.controller;

import com.wjahatsyed.portfolio.shopping_cart.model.Cart;
import com.wjahatsyed.portfolio.shopping_cart.model.CartItem;
import com.wjahatsyed.portfolio.shopping_cart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<String> addItem(@PathVariable String userId, @RequestBody CartItem item) {
        cartService.updateCart(userId, item);
        return ResponseEntity.ok("Item added successfully");
    }
}

