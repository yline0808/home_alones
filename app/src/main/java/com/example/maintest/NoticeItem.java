package com.example.maintest;

import java.io.Serializable;
import java.util.ArrayList;

public class NoticeItem implements Serializable {
    String title;       //제목
    String summary;     //내용요약
    String time;        //게시기간
    int like;           //좋아요 수
    int comment;        //댓글 수
    String contents;     //내용
    ArrayList<CommentItem> comment_all;

    public NoticeItem() {
    }

    public NoticeItem(String title, String contents, String time, int like, int comment) {
        this.title = title;
        this.time = time;
        this.like = like;
        this.comment = comment;
        this.contents = contents;
        this.summary = settingSummary(contents);
    }

    public NoticeItem(String title, String contents, String time, int like, int comment, ArrayList<CommentItem> comment_all) {
        this.title = title;
        this.time = time;
        this.like = like;
        this.comment = comment;
        this.contents = contents;
        this.summary = settingSummary(contents);
        this.comment_all = comment_all;
    }

    public String settingSummary(String contents){
        String str = "";

        if(contents.length() > 23){
            for(int j = 0; j < 23; j++){
                str += contents.charAt(j);
            }
            str += "...";
        }else{
            str = contents;
        }
        return str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String contents) {
        this.summary = settingSummary(contents);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public ArrayList<CommentItem> getComment_all() {
        return comment_all;
    }

    public void setComment_all(ArrayList<CommentItem> comment_all) {
        this.comment_all = comment_all;
    }

    @Override
    public String toString() {
        return "NoticeItem{" +'\n' +
                "title='" + title + '\n' +
                ", summary='" + summary + '\n' +
                ", time='" + time + '\n' +
                ", like=" + like +'\n' +
                ", comment=" + comment +'\n' +
                ", contents='" + contents + '\n' +
                ", comment_all=" + comment_all.toString() +
                '}';
    }
}