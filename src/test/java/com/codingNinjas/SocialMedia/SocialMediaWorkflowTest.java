package com.codingNinjas.SocialMedia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SocialMediaWorkflowTest {

    @Test
    void createsAndListsMultiplePosts() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            SocialMediaWorkflow workflow = new SocialMediaWorkflow(
                    context,
                    scannerFor("Bipin", "1", "First post", "1", "Second post", "2", "3")
            );

            String output = ConsoleTestSupport.captureOutput(workflow::run);

            assertTrue(output.contains("Post created successfully."));
            assertTrue(output.contains("All the posts!"));
            assertTrue(output.contains("0- Bipin First post"));
            assertTrue(output.contains("1- Bipin Second post"));
            assertTrue(output.contains("Exiting social media app."));
        }
    }

    @Test
    void retriesBlankPostBeforeCreatingIt() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            SocialMediaWorkflow workflow = new SocialMediaWorkflow(
                    context,
                    scannerFor("Bipin", "1", "", "Hello", "2", "3")
            );

            String output = ConsoleTestSupport.captureOutput(workflow::run);

            assertTrue(output.contains("Value cannot be blank. Please try again."));
            assertTrue(output.contains("0- Bipin Hello"));
        }
    }

    @Test
    void handlesInvalidMenuChoiceAndEmptyFeed() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            SocialMediaWorkflow workflow = new SocialMediaWorkflow(
                    context,
                    scannerFor("Bipin", "9", "2", "3")
            );

            String output = ConsoleTestSupport.captureOutput(workflow::run);

            assertTrue(output.contains("Invalid choice."));
            assertTrue(output.contains("No posts available."));
        }
    }

    @Test
    void retriesBlankUserNameBeforeShowingMenu() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            SocialMediaWorkflow workflow = new SocialMediaWorkflow(
                    context,
                    scannerFor("", "Bipin", "3")
            );

            String output = ConsoleTestSupport.captureOutput(workflow::run);

            assertTrue(output.contains("Please enter your name!"));
            assertTrue(output.contains("Value cannot be blank. Please try again."));
            assertTrue(output.contains("Exiting social media app."));
        }
    }

    private Scanner scannerFor(String... lines) {
        String input = String.join(System.lineSeparator(), lines) + System.lineSeparator();
        return new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
}
