package com.codingNinjas.SocialMedia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    void storesPostMessage() {
        SimplePost post = new SimplePost();
        post.setMessage("Hello world");

        assertEquals("Hello world", post.getMessage());
    }

    @Test
    void initializesDefaultPostAndPrintsDestroyMessages() {
        SimplePostList postList = new SimplePostList();

        String initOutput = ConsoleTestSupport.captureOutput(postList::init);
        String destroyOutput = ConsoleTestSupport.captureOutput(() -> {
            postList.destroy();
            new SimplePost().destroy();
        });

        assertTrue(initOutput.isEmpty());
        assertEquals(1, postList.size());
        assertEquals("From DB", postList.getPost(0).getMessage());
        assertTrue(destroyOutput.contains("Post list destroyed"));
        assertTrue(destroyOutput.contains("Post destroyed"));
    }
}
