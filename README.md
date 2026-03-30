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

## API endpoint table

| Purpose | Direct base URL | Gateway base URL | Gateway path |
| --- | --- | --- | --- |
| Products | `http://localhost:8081/products` | `http://localhost:8080/api/products` | `GET, POST, PUT, DELETE` |
| Customers | `http://localhost:8082/customers` | `http://localhost:8080/api/customers` | `GET, POST, PUT, DELETE` |
| Inventory | `http://localhost:8083/inventory` | `http://localhost:8080/api/inventory` | `GET, POST, PUT, DELETE` |
| Orders | `http://localhost:8084/orders` | `http://localhost:8080/api/orders` | `GET, POST, PUT, DELETE` |
| Payments | `http://localhost:8085/payments` | `http://localhost:8080/api/payments` | `GET, POST, PUT, DELETE` |
| Shipping | `http://localhost:8086/shipping` | `http://localhost:8080/api/shipping` | `GET, POST, PUT, DELETE` |

## Swagger URLs

- Gateway Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Product Swagger UI: `http://localhost:8081/swagger-ui/index.html`
- Customer Swagger UI: `http://localhost:8082/swagger-ui/index.html`
- Inventory Swagger UI: `http://localhost:8083/swagger-ui/index.html`
- Order Swagger UI: `http://localhost:8084/swagger-ui/index.html`
- Payment Swagger UI: `http://localhost:8085/swagger-ui/index.html`
- Shipping Swagger UI: `http://localhost:8086/swagger-ui/index.html`

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
