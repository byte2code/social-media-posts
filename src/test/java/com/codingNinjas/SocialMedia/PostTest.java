package com.codingNinjas.SocialMedia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    void storesPostMessage() {
        SimplePost post = new SimplePost();
        post.setMessage("Hello world");

        assertEquals("Hello world", post.getMessage());
    }
}
