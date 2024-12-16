package com.wjahatsyed.portfolio.shopping_cart.model;

import java.io.Serializable;

public class Message implements Serializable {
    private String id;
    private String content;

    public Message() {}

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

