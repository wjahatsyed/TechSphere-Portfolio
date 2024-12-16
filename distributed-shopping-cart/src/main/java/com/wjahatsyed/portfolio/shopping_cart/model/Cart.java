package com.wjahatsyed.portfolio.shopping_cart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String userId;
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem item) {
        this.items.add(item);
    }
}

