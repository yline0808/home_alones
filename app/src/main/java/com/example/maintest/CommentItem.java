package com.example.maintest;

import java.io.Serializable;

public class CommentItem implements Serializable {
    String text;
    String time;

    public CommentItem() {
    }

    public CommentItem(String text, String time) {
        this.text = text;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CommentItem{" +'\n' +
                "text='" + text + '\n' +
                ", time='" + time + '\n' +
                '}';
    }
}