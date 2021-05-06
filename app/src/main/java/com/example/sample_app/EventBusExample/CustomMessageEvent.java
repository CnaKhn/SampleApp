package com.example.sample_app.EventBusExample;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusBuilder;

public class CustomMessageEvent {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
