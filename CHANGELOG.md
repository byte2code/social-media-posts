# Changelog

All notable changes to this project are documented in this file.

## [v2.0.0] - 2026-03-20

### Summary
Second version of the Social Media Posts project that introduces a Spring-wired user for the current session.

### Highlights
- Added `User` and `SimpleUser` to hold the session username and post list.
- Updated the console workflow to prompt for the user name before showing the menu.
- Updated post-list output to include the current user name with each post.
- Expanded tests to cover user bean wiring and username-driven workflow behavior.
- Updated the README for the new author-aware flow.

### Notes
This version evolves the project from a generic post list into a simple single-user posting session.

## [v1.0.0] - 2026-03-19

### Summary
Initial version of the Social Media Posts project built as a Java 17 console application with Spring XML bean configuration.

### Highlights
- Added post and post-list abstractions for a simple text posting flow.
- Added Spring XML wiring for a prototype post bean and shared post list.
- Added a console workflow for creating and listing posts.
- Added tests for bean scopes, post behavior, and workflow output.
- Added GitHub-ready documentation and changelog files.

### Notes
This version establishes the project as a compact social-media posting demo suitable for GitHub and portfolio presentation.
