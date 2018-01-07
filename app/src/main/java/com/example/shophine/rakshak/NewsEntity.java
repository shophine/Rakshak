package com.example.shophine.rakshak;

/**
 * Created by shophine on 7/1/18.
 */

public class NewsEntity {
    int id;
    String headline;
    String content;

    public NewsEntity(int id, String headline, String content) {
        this.id = id;
        this.headline = headline;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsEntity() {

    }
}
