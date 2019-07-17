package com.codecool.web.model;

import java.util.Date;

public final class Tweet {
    private String poster;
    private String content;
    private Date date = new Date();
    
    public Tweet(String poster, String content) {
        this.poster = poster;
        this.content = content;
    }
    
    public String getPoster() {
        return poster;
    }
    
    public String getContent() {
        return content;
    }
    
    public Date getDate() {
        return date;
    }
}
