package com.example.chatting;

import android.annotation.SuppressLint;

import java.util.Calendar;

public class ChatBox {
    private String name;
    private String text;
    private String time;


    @SuppressLint("DefaultLocale")
    public ChatBox(String name, String text) {
        int currentTime = Calendar.getInstance().getTime().getHours();
        int currentTime1 = Calendar.getInstance().getTime().getMinutes();
        this.name = name;
        this.text = text;
        this.time = String.format("%02d", currentTime) + ":" + String.format("%02d", currentTime1);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }
}
