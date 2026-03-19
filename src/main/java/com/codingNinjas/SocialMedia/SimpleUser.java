package com.codingNinjas.SocialMedia;

public class SimpleUser implements User {

    private String userName;
    private PostList postList;

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public PostList getPostList() {
        return postList;
    }

    @Override
    public void setPostList(PostList postList) {
        this.postList = postList;
    }
}
