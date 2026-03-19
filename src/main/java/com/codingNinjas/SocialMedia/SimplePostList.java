package com.codingNinjas.SocialMedia;

import java.util.ArrayList;

public class SimplePostList implements PostList{

    private final ArrayList<Post> postList;

    public SimplePostList(){
        this.postList = new ArrayList<Post>();
    }

    @Override
    public ArrayList<Post> getAllPosts() {
        return this.postList;
    }

    @Override
    public Post getPost(int i) {
        return this.postList.get(i);
    }

    @Override
    public void setPost(Post post) {
        this.postList.add(post);
    }

    @Override
    public int size() {
        return this.postList.size();
    }

}
