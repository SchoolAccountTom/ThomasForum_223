package com.wiss.m223.controller;

public class MessageResponse {

    private String message;

    public MessageResponse(String messsage) {
        this.message = messsage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
