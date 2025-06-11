# Prices API - Spring Boot Hexagonal Architecture

![Backend](https://img.shields.io/badge/backend-Java%2021-orange?style=flat-square)
![Framework](https://img.shields.io/badge/framework-Spring%20Boot-6db33f?style=flat-square)
![Architecture](https://img.shields.io/badge/architecture-Hexagonal-blueviolet?style=flat-square)
![Tests](https://img.shields.io/badge/tests-JUnit%205-blue?style=flat-square)

---

## 📄 Description

This backend service, built with Java 21 and Spring Boot, provides a REST API to retrieve the applicable price for a given product, brand and date. It follows hexagonal architecture, with clear separation between domain, application and infrastructure layers. Data is loaded from an in-memory H2 database and the logic selects the highest-priority price from overlapping records.


## ✨ Features
- REST API to query prices: GET /prices
- Filters by date, product ID and brand ID
- Selects correct price based on priority
- H2 in-memory DB preloaded with sample data
- Hexagonal architecture with DTOs, ports, use cases and mappers
- Unit tests for use cases and integration tests for the API
- Control de errores y excepciones personalizadas
- Swagger documentation auto-generated

---

## 🧱 Project Structure
```bash
src/main/java/com/example/prices/
├── application/               # Use cases (FindApplicablePriceUseCase)
├── configuration/             # Spring beans configuration
├── domain/                    # Domain model and ports
│   ├── model/                 # Price record
│   └── port/                  # PriceRepository (domain interface)
├── infrastructure/            # Adapters and technical implementations
│   ├── controller/            # PriceController (REST)
│   ├── dto/                   # PriceResponseDTO
│   ├── entity/                # PriceEntity for JPA
│   ├── mapper/                # PriceMapper
│   └── repository/            # JpaPriceRepository and SpringDataPriceRepository
└── PricesApplication.java     # Main Spring Boot entry point
```
---

## 💻 Tech Stack

- **Java 21**
- **Spring Boot**
- **H2 Database (in-memory)**
- **Spring Data JPA**
- **JUnit 5 + Mockito** 
- **Springdoc OpenAPI** for Swagger
---

## 📋 Requirements

- **Java 21** 
- **IDE (recommended: IntelliJ IDEA)**
- **Maven 3+**

---

## 🧪 Testing

### Integration tests
- Verify endpoint /prices with five scenarios based on the sample data.

### Unit tests
- Validate use case FindApplicablePriceUseCase using mocked repository.
- Ensure correct price is selected based on priority.

Frameworks:

- JUnit 5
- Mockito
---

## 🛠️ Installation
```bash
git clone https://github.com/eze-ms/Backend-Java-Hexagonal-Architecture
```

Run Locally:
```bash
./mvn spring-boot:run

```
Swagger available at:
```bash
http://localhost:8080/swagger-ui.html
```

H2 Console:
```bash
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:pricesdb
User: sa
Password: password
```
---

© 2025. Developed by Ezequiel Macchi Seoane.
