package com.codingNinjas.SocialMedia;

import java.util.ArrayList;

public interface PostList {

    ArrayList<Post> getAllPosts();

    Post getPost(int i);

    void setPost(Post post);

    int size();
}
