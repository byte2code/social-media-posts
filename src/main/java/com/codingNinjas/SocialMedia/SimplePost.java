package com.codingNinjas.SocialMedia;

public class SimplePost implements Post{

    private String message;

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
