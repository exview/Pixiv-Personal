package com.example.leave.myapplication;

import java.util.HashMap;

/**
 * Created by leave on 2017/12/10.
 */

public class Picture {
    private int id;
    private String title;
    private String caption;
    private String[] tags;
    private HashMap<String,String> image_urls;
    private int weight;
    private int height;
    private User user;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public HashMap<String, String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(HashMap<String, String> image_urls) {
        this.image_urls = image_urls;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
