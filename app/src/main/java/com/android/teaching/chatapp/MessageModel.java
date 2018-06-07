package com.android.teaching.chatapp;

public class MessageModel {

    private String username;
    private String text;


    public MessageModel() {

    }

    public MessageModel(String username, String message) {
        this.username = username;
        this.text = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return text;
    }

    public void setMessage(String message) {
        this.text = message;
    }
}
