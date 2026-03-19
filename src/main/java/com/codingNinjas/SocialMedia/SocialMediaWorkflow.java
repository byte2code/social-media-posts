package com.codingNinjas.SocialMedia;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

public class SocialMediaWorkflow {

    private final ApplicationContext context;
    private final Scanner scanner;
    private final User user;

    public SocialMediaWorkflow(ApplicationContext context, Scanner scanner) {
        this.context = context;
        this.scanner = scanner;
        this.user = context.getBean("simpleUser", User.class);
    }

    public void run() {
        PostList postList = user.getPostList();
        System.out.println("Social media app starts.....");
        user.setUserName(promptForNonBlank("Please enter your name!"));

        while (true) {
            Integer menuItem = promptForMenuChoice(
                    "1- make new post",
                    "2- show all posts",
                    "3- exit"
            );

            switch (menuItem) {
                case 1 -> createPost(postList);
                case 2 -> printPosts(postList);
                case 3 -> {
                    System.out.println("Exiting social media app.");
                    return;
                }
                default -> throw new IllegalStateException("Unexpected menu item: " + menuItem);
            }
        }
    }

    private void createPost(PostList postList) {
        Post post = context.getBean("simplePost", Post.class);
        post.setMessage(promptForNonBlank("Please enter a post"));
        postList.setPost(post);
        System.out.println("Post created successfully.");
    }

    private void printPosts(PostList postList) {
        System.out.println("All the posts!");
        if (postList.size() == 0) {
            System.out.println("No posts available.");
            return;
        }

        for (int i = 0; i < postList.size(); i++) {
            System.out.println(i + "- " + user.getUserName() + " " + postList.getPost(i).getMessage());
        }
    }

    private Integer promptForMenuChoice(String... options) {
        while (true) {
            for (String option : options) {
                System.out.println(option);
            }

            Integer value = parseInteger(readLine());
            if (value != null && value >= 1 && value <= options.length) {
                return value;
            }

            System.out.println("Invalid choice.");
        }
    }

    private String promptForNonBlank(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = readLine();
            if (value != null && !value.isBlank()) {
                return value;
            }

            System.out.println("Value cannot be blank. Please try again.");
        }
    }

    private String readLine() {
        if (!scanner.hasNextLine()) {
            return null;
        }

        return scanner.nextLine().trim();
    }

    private Integer parseInteger(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return null;
        }
    }
}
