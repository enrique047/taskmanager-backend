# Task Manager Backend

A Spring Boot REST API for managing tasks. The application provides endpoints to create, retrieve, update, and delete tasks using a layered backend architecture.

## Tech Stack

Java
Spring Boot
Spring Web
Spring Data JPA
Hibernate
Maven
MySQL

## Architecture

The project follows a layered architecture:
Controller → Service → Repository → Database
Controller – Handles HTTP requests and responses
Service – Contains business logic
Repository – Performs database operations using Spring Data JPA
Entity – Represents the Task model stored in the database
