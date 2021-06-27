package com.example.chatting.RecViewItems;

public class MyPageList {
    private String title;
    boolean hasArrow;

    public MyPageList(String title, boolean hasArrow) {
        this.title = title;
        this.hasArrow = hasArrow;
    }

    @Override
    public String toString() {
        return "MyPageList{" +
                "title='" + title + '\'' +
                ", hasArrow=" + hasArrow +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHasArrow(boolean hasArrow) {
        this.hasArrow = hasArrow;
    }

    public String getTitle() {
        return title;
    }

    public boolean isHasArrow() {
        return hasArrow;
    }
}