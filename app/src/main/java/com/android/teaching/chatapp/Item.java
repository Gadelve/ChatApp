package com.android.teaching.chatapp;

public class Item {
    private String username;
    private String message;

    public Item(String name, String description) {
        this.username = name;
        this.message = description;
    }

    public String getItemName() {
        return this.username;
    }

    public String getItemDescription() {
        return message;
    }
}
