# MTIT-Assignment02

Backend starter scaffold for the MTIT Assignment 02 microservices submission.

## Project layout

- `api-gateway/` contains the single entry point for all services.
- `product-service/`, `customer-service/`, `inventory-service/`, `order-service/`, `payment-service/`, and `shipping-service/` contain the six member-owned microservices.
- `assignment-support/` contains the non-code submission material such as documentation notes, slide placeholders, screenshot placeholders, and Postman notes.

## Tech stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 database
- Springdoc Swagger UI
- Spring Cloud Gateway
- Docker Compose

## Current status

- The repository now contains a clean multi-service folder structure.
- Each service has its own package layout and starter files.
- H2 is configured as the database choice for each service.
- The next step is implementing the actual CRUD logic and then replacing the support placeholders with real screenshots and slides.
