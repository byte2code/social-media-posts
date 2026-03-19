# Social Media Posts

Social Media Posts is a Java 17 console application that uses Spring XML bean configuration to create and list simple text posts.

## GitHub Metadata

- Suggested repository description: `Java 17 Spring console app for creating and listing social media posts using XML bean scopes.`
- Suggested topics: `java`, `java-17`, `spring-framework`, `spring`, `maven`, `xml-configuration`, `dependency-injection`, `junit5`, `oop`, `console-application`, `social-media`, `learning-project`, `portfolio-project`

## Tech Stack

- Java 17
- Maven
- Spring Framework XML configuration
- JUnit 5

## Project Overview

The application models a simple social-media posting flow:

- `SimplePost` implements the `Post` interface.
- `SimplePostList` implements the `PostList` interface and stores posts for the session.
- `SocialMediaWorkflow` manages console interaction and validation.
- `applicationContext.xml` wires a prototype post bean and a shared post-list bean.

## Current Flow

1. The application starts in `SocialMediaApplication`.
2. Spring loads `applicationContext.xml`.
3. The user chooses to create a post, show all posts, or exit.
4. If a post is created, the app collects the message and stores it in the post list.
5. The user can view all posts added during the current session.
6. The app exits when the user chooses option `3`.

## Flow Diagram

```mermaid
flowchart TD
    A["Start: SocialMediaApplication.main()"] --> B["Load Spring XML context<br/>applicationContext.xml"]
    B --> C["Show main menu"]
    C --> D{"User choice"}
    D -->|"1"| E["Create prototype post bean"]
    E --> F["Collect post message"]
    F --> G["Add post to shared post list"]
    G --> C
    D -->|"2"| H["Print all posts from post list"]
    H --> C
    D -->|"3"| I["Exit application"]
    D -->|"Invalid"| J["Show invalid choice and retry"]
    J --> C
```

## How To Run

```bash
mvn test
mvn package
java -jar target/social-media-posts-0.0.1-SNAPSHOT.jar
```

If you prefer the Maven Wrapper, use `mvnw.cmd` on Windows or `./mvnw` on Unix-like systems.

## Sample Output

```text
Social media app starts.....
1- make new post
2- show all posts
3- exit
Please enter a post
Post created successfully.
All the posts!
0-Hello world
Exiting social media app.
```

## Known Limitations

- The application is console-based and does not expose a REST API.
- Posts are stored only for the current runtime session.
- There is no author identity, likes, comments, or persistence layer.

## Why This Repo Exists

This repository is intended as a learning and portfolio project that shows:

- Spring XML bean scopes
- interface-based design
- console workflow handling
- stateful in-memory collections
- automated tests for wiring and post-creation flow
