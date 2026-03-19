package com.codingNinjas.SocialMedia;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SocialMediaApplication {

    public static void main(String[] args) {
        try (
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                Scanner scanner = new Scanner(System.in)
        ) {
            new SocialMediaWorkflow(context, scanner).run();
        }
    }
}
