# 🛒 E-Commerce REST API

A fully functional and secured E-Commerce REST API built with **Java Spring Boot**, **PostgreSQL** and **JWT Authentication**.

---

## 👨‍💻 Author
**David Kayima**  
Junior Backend Developer  
Uganda 🇺🇬

---

## 🚀 Features

- ✅ Full CRUD operations for Products, Categories, Orders, Order Items and Users
- ✅ PostgreSQL database integration with Spring Data JPA
- ✅ JWT Authentication and Authorization
- ✅ Password encryption with BCrypt
- ✅ Global Exception Handling with clean error responses
- ✅ Protected API endpoints with Spring Security
- ✅ Stateless session management

---

## 🛠️ Technologies Used

| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 3.4.3 |
| Spring Security | 3.4.3 |
| Spring Data JPA | 3.4.3 |
| PostgreSQL | 18.2 |
| JWT (jjwt) | 0.11.5 |
| Maven | 3.9.10 |

---

## 📁 Project Structure

```
src/main/java/com/example/ecommerce/
│
├── auth/
│   ├── AuthController.java
│   ├── AuthService.java
│   ├── LoginRequest.java
│   └── RegisterRequest.java
│
├── exception/
│   ├── ApiException.java
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
│
├── security/
│   ├── JwtAuthenticationFilter.java
│   ├── JwtUtil.java
│   └── SecurityConfig.java
│
├── Category.java
├── CategoryController.java
├── CategoryRepository.java
├── CategoryService.java
│
├── Product.java
├── ProductController.java
├── ProductRepository.java
├── ProductService.java
│
├── Order.java
├── OrderController.java
├── OrderRepository.java
├── OrderService.java
│
├── OrderItem.java
├── OrderItemController.java
├── OrderItemRepository.java
├── OrderItemService.java
│
├── User.java
├── UserController.java
├── UserRepository.java
└── UserService.java
```

---

## ⚙️ Setup and Installation

### Prerequisites
- Java 21
- Maven
- PostgreSQL
- IntelliJ IDEA (recommended)

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/yourusername/e-commerce-api.git
cd e-commerce-api
```

**2. Create the database**

Open pgAdmin and create a database called:
```
ecommerce_db
```

**3. Configure application.properties**

Open `src/main/resources/application.properties` and update:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=postgres
spring.datasource.password=your_password_here

jwt.secret=your_super_secret_key_that_is_at_least_32_characters
jwt.expiration=86400000
```

**4. Run the application**
```bash
mvn clean install
mvn spring-boot:run
```

The app will start on **http://localhost:8080**

---

## 🔐 Authentication

This API uses **JWT Bearer Token** authentication.

### Register
```http
POST /auth/register
Content-Type: application/json

{
    "name": "David Kayima",
    "email": "david@example.com",
    "password": "password123"
}
```

### Login
```http
POST /auth/login
Content-Type: application/json

{
    "email": "david@example.com",
    "password": "password123"
}
```

Both endpoints return a token:
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Use this token in all protected requests:
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

---

## 📌 API Endpoints

### Auth
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | /auth/register | Register a new user | ❌ |
| POST | /auth/login | Login and get token | ❌ |

### Products
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | /products | Get all products | ✅ |
| GET | /products/{id} | Get product by ID | ✅ |
| POST | /products | Create a product | ✅ |
| PUT | /products/{id} | Update a product | ✅ |
| DELETE | /products/{id} | Delete a product | ✅ |

### Categories
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | /categories | Get all categories | ✅ |
| GET | /categories/{id} | Get category by ID | ✅ |
| POST | /categories | Create a category | ✅ |
| PUT | /categories/{id} | Update a category | ✅ |
| DELETE | /categories/{id} | Delete a category | ✅ |

### Orders
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | /orders | Get all orders | ✅ |
| GET | /orders/{id} | Get order by ID | ✅ |
| POST | /orders | Create an order | ✅ |
| PUT | /orders/{id} | Update an order | ✅ |
| DELETE | /orders/{id} | Delete an order | ✅ |

### Users
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | /users | Get all users | ✅ |
| GET | /users/{id} | Get user by ID | ✅ |
| POST | /users | Create a user | ✅ |
| PUT | /users/{id} | Update a user | ✅ |
| DELETE | /users/{id} | Delete a user | ✅ |

---

## ⚠️ Error Responses

All errors return a clean JSON response:

```json
{
    "status": 404,
    "message": "Product with ID 99 not found",
    "timestamp": "2026-03-10T18:00:00"
}
```

---

## 🌱 Future Improvements

- [ ] Input validation with `@Valid`
- [ ] Admin and User roles
- [ ] Pagination and sorting
- [ ] Docker containerization
- [ ] Cloud deployment (Railway / Render)

---

## 📄 License
This project is open source and available under the [MIT License](LICENSE).