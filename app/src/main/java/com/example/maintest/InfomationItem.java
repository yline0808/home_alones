package com.example.maintest;

import java.io.Serializable;

public class InfomationItem implements Serializable {
    String host;
    String title;
    String url;

    public InfomationItem() {
    }

    public InfomationItem(String host, String title) {
        this.host = host;
        this.title = title;
    }

    public InfomationItem(String host, String title, String url) {
        this.host = host;
        this.title = title;
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "InfomationItem{" +'\n' +
                "host='" + host + '\n' +
                ", title='" + title + '\n' +
                ", url='" + url + '\n' +
                '}';
    }
}
