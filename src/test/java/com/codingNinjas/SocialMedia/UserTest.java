package com.codingNinjas.SocialMedia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void storesUserNameAndPostList() {
        SimpleUser user = new SimpleUser();
        PostList postList = new SimplePostList();

        user.setUserName("Bipin");
        user.setPostList(postList);

        assertEquals("Bipin", user.getUserName());
        assertSame(postList, user.getPostList());
    }
}
