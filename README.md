# Local Services Backend API

A Spring Boot REST API for managing local service providers (Electricians, Plumbers, etc.) with secure authentication and role-based access control.

---

## 🚀 Features

- User Registration & Login (JWT Authentication)
- Role-Based Authorization (ADMIN / USER)
- CRUD Operations for Service Providers
- Pagination, Filtering & Sorting
- Global Exception Handling
- Input Validation
- Swagger API Documentation

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- MySQL
- Lombok

---

## 🔐 Authentication

Users login and receive a JWT token.

Include token in headers:

Authorization: Bearer <token>

---

## 📌 API Endpoints

### Auth
- POST /auth/register
- POST /auth/login

### Providers
- GET /providers
- GET /providers/{id}
- POST /providers (ADMIN)
- PUT /providers/{id} (ADMIN)
- DELETE /providers/{id} (ADMIN)

---

## 📊 Pagination Example

GET /providers?page=0&size=5&sort=name

---

## ⚙️ Run Locally

1. Clone repository
2. Configure MySQL in `application.properties`
3. Run Spring Boot application

---

## 👨‍💻 Author

Jay Kant