# MTIT-Assignment02

Backend implementation for the MTIT Assignment 02 microservices submission.

## Project layout

- `api-gateway/` contains the single entry point for all services.
- `product-service/`, `customer-service/`, `inventory-service/`, `order-service/`, `payment-service/`, and `shipping-service/` contain the six member-owned microservices.

## Tech stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 database
- Springdoc Swagger UI
- Spring Cloud Gateway
- Docker Compose

## Services and ports

- `api-gateway` -> `8080`
- `product-service` -> `8081`
- `customer-service` -> `8082`
- `inventory-service` -> `8083`
- `order-service` -> `8084`
- `payment-service` -> `8085`
- `shipping-service` -> `8086`

## What is implemented

- Full CRUD endpoints for all six microservices
- API Gateway routing for CRUD access through one port
- Gateway Swagger UI with all six service API docs
- Gateway proxy paths for each service API docs
- H2 in-memory database per service with seed data
- Dockerfiles for every service and gateway
- Docker Compose setup for the full backend

## Direct Swagger URLs

- `http://localhost:8081/swagger-ui/index.html`
- `http://localhost:8082/swagger-ui/index.html`
- `http://localhost:8083/swagger-ui/index.html`
- `http://localhost:8084/swagger-ui/index.html`
- `http://localhost:8085/swagger-ui/index.html`
- `http://localhost:8086/swagger-ui/index.html`

## Swagger through the API Gateway

- Main gateway Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Service docs through gateway:
  - `http://localhost:8080/product-service/v3/api-docs`
  - `http://localhost:8080/customer-service/v3/api-docs`
  - `http://localhost:8080/inventory-service/v3/api-docs`
  - `http://localhost:8080/order-service/v3/api-docs`
  - `http://localhost:8080/payment-service/v3/api-docs`
  - `http://localhost:8080/shipping-service/v3/api-docs`

## Example gateway CRUD URLs

- `GET http://localhost:8080/api/products`
- `GET http://localhost:8080/api/customers`
- `GET http://localhost:8080/api/inventory`
- `GET http://localhost:8080/api/orders`
- `GET http://localhost:8080/api/payments`
- `GET http://localhost:8080/api/shipping`

## How to run locally

Start each service in a separate terminal:

```bash
cd product-service && mvn spring-boot:run
cd customer-service && mvn spring-boot:run
cd inventory-service && mvn spring-boot:run
cd order-service && mvn spring-boot:run
cd payment-service && mvn spring-boot:run
cd shipping-service && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run
```

Or run a full verification build from the repository root:

```bash
mvn -q test
```

## How to run with Docker

```bash
docker compose up --build
```

## Notes

- The database is H2 and starts with sample records for demo purposes.
- Data resets whenever a service restarts because this setup is optimized for assignment demonstration, not production persistence.
- The `assignment-support/` folder is where you should place your final screenshots, diagrams, slides, and Postman collection.
- For the presentation, show direct service Swagger on ports `8081` to `8086`, then show the combined gateway Swagger page on port `8080`.
- If a port is already in use on your machine, stop the conflicting process or change the `server.port` value in that service's `application.yml`.
