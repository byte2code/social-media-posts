package com.codingNinjas.SocialMedia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ApplicationContextTest {

    @Test
    void loadsPrototypePostAndSingletonPostListBeans() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Post firstPost = context.getBean("simplePost", Post.class);
            Post secondPost = context.getBean("simplePost", Post.class);
            PostList firstList = context.getBean("simplePostList", PostList.class);
            PostList secondList = context.getBean("simplePostList", PostList.class);
            User user = context.getBean("simpleUser", User.class);

            assertNotNull(firstPost);
            assertNotNull(secondPost);
            assertNotNull(firstList);
            assertNotNull(secondList);
            assertNotNull(user);
            assertTrue(firstPost != secondPost);
            assertTrue(firstList == secondList);
            assertTrue(user.getPostList() == firstList);
            assertEquals(1, firstList.size());
            assertEquals("From DB", firstList.getPost(0).getMessage());
        }
    }
}
