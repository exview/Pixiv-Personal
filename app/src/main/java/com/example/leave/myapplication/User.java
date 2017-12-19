package com.example.leave.myapplication;

import java.util.HashMap;

/**
 * Created by leave on 2017/12/10.
 */

public class User {
    private int id;
    private String account;
    private String name;
    private HashMap<String, String> profile_image_urls;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String, String> getProfile_image_urls() {
        return profile_image_urls;
    }

    public void setProfile_image_urls(HashMap<String, String> profile_image_urls) {
        this.profile_image_urls = profile_image_urls;
    }

    public void setName(String name) {
        this.name = name;
    }
}
