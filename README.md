# Social Media Posts

Social Media Posts is a Java 17 console application that uses Spring XML bean configuration to create and list simple text posts for a session-based user.

## GitHub Metadata

- Suggested repository description: `Java 17 Spring console app for user-specific social media posts with Spring XML wiring and bean lifecycle callbacks.`
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
- `SimpleUser` implements the `User` interface and owns the post list for the current session.
- `SocialMediaWorkflow` manages console interaction and validation.
- `applicationContext.xml` wires a prototype post bean, a shared post-list bean, and a user bean.
- `SimplePostList` now seeds one default post during bean initialization and logs when the bean is destroyed.

## Current Flow

1. The application starts in `SocialMediaApplication`.
2. Spring loads `applicationContext.xml`.
3. The user enters a name for the current session.
4. The user chooses to create a post, show all posts, or exit.
5. During startup, the singleton post list initializes with one default `From DB` post.
6. If a post is created, the app collects the message and stores it in the user-owned post list.
7. The user can view all posts added during the current session with the username prefixed in the output.
8. When the application closes, Spring triggers bean destroy callbacks for the managed singleton bean.

## Flow Diagram

```mermaid
flowchart TD
    A["Start: SocialMediaApplication.main()"] --> B["Load Spring XML context<br/>applicationContext.xml"]
    B --> C["Prompt for user name"]
    C --> D["Show main menu"]
    D --> E["Initialize shared post list with default post"]
    E --> F{"User choice"}
    F -->|"1"| G["Create prototype post bean"]
    G --> H["Collect post message"]
    H --> I["Add post to user-owned post list"]
    I --> D
    F -->|"2"| J["Print all posts with user name prefix"]
    J --> D
    F -->|"3"| K["Exit application and close context"]
    F -->|"Invalid"| L["Show invalid choice and retry"]
    L --> D
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
Please enter your name!
1- make new post
2- show all posts
3- exit
Please enter a post
Post created successfully.
All the posts!
0- Bipin From DB
1- Bipin Hello world
Exiting social media app.
```

## Known Limitations

- The application is console-based and does not expose a REST API.
- Posts are stored only for the current runtime session.
- There is still no persistence layer, likes, comments, or multi-user storage.
- Prototype bean destroy hooks are configured for learning purposes, but Spring does not automatically manage prototype destruction on context close.

## Why This Repo Exists

This repository is intended as a learning and portfolio project that shows:

- Spring XML bean scopes
- interface-based design
- console workflow handling
- stateful in-memory collections
- automated tests for wiring and post-creation flow
