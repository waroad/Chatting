package com.example.chatting;

public class ChatList {
    private String title;
    private int userNum;
    private boolean newMessage;

    public ChatList(String title, int userNum, boolean newMessage) {
        this.title = title;
        this.userNum = userNum;
        this.newMessage = newMessage;
    }

    @Override
    public String toString() {
        return "ChatList{" +
                "title='" + title + '\'' +
                ", userNum=" + userNum +
                ", newMessage=" + newMessage +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public void setNewMessage(boolean newMessage) {
        this.newMessage = newMessage;
    }

    public String getTitle() {
        return title;
    }

    public String getUserNum() {
        return userNum +"명";
    }

    public boolean isNewMessage() {
        return newMessage;
    }
}
