# 🏰 Royal Treasury SOAP Service

Enterprise backend project simulating a medieval financial cooperative system.

This system represents a **royal treasury** responsible for managing noble accounts, authorizing payments and recording financial transactions — inspired by real-world banking architectures.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Web (REST)
* Spring WS (SOAP)
* Oracle (relational database)
* MongoDB (audit logs)
* Docker

---

## 🧠 Architecture

This project follows a layered architecture:

Controller → Service → Repository → Database

### Layers

* **Controller** → exposes REST endpoints
* **Service** → business rules and financial logic
* **Repository** → database access
* **Domain** → core business entities

---

## 💰 Financial Model (Important)

Instead of storing account balance directly, this system uses a **transaction-based ledger model**.

Balance is calculated as:

balance = deposits - payments

This approach ensures:

* auditability
* consistency
* traceability
* real-world financial modeling

---

## 📦 Features (Current)

* Create noble account
* Deposit funds
* Perform payments
* Calculate account balance
* Transaction history tracking

---

## 🔗 API Endpoints

### Create Account

POST /accounts

### Get Account

GET /accounts/{id}

### Get Balance

GET /accounts/{id}/balance

### Deposit

POST /transactions/deposit

### Payment

POST /transactions/payment

---

## 🐳 Running the project

```bash
docker compose up -d
```

Then run the Spring Boot application.

---

## 🎯 Purpose

This project was designed to simulate:

* enterprise backend architecture
* financial system design
* legacy + modern integration (SOAP + REST)
* clean code and SOLID principles

---

## 🚧 Work in Progress

* SOAP endpoints
* Audit logging with MongoDB
* Unit and integration tests
* Security layer
