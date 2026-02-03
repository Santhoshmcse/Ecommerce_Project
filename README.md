# E-Commerce Backend API (Spring Boot)

## Overview
This project is a backend REST API for an e-commerce system built using **Spring Boot**.  
It focuses on **clean domain modeling** and **real-world business rules**, including cart management, checkout validation, and immutable order creation.

The system separates **temporary cart state** from **permanent orders**, handles **product availability and soft deletion**, and ensures **pricing consistency** across the purchase lifecycle.

---

## Tech Stack
- Java 17  
- Spring Boot  
- Spring Security + JWT  
- Spring Data JPA (Hibernate)  
- MySQL / PostgreSQL  
- Maven  

---

## High-Level Flow

### Design Highlights
- Cart is **mutable and temporary**
- Order is **immutable and a snapshot**
- Product price is **frozen at cart time**
- Product lifecycle handled using **active + soft delete**
- Stock is reduced **only after payment success**

---

## Modules Implemented

### Authentication & Authorization
- JWT-based authentication
- Role-based authorization (USER / ADMIN)
- Secure access using Spring Security

### Product Management
- Product CRUD operations
- `active` flag for temporary availability
- `deleted` flag for soft deletion (lifecycle removal)
- Indexed search fields for performance

### Cart Management
- One cart per user
- Add, update, remove cart items
- Prevents duplicate products in cart
- Stores `priceAtAddTime` to preserve pricing

### Checkout
- Validation layer between cart and order
- Re-checks:
  - Product availability
  - Soft deletion
  - Stock availability
- Recalculates total amount
- No database mutation

### Order Management
- Immutable order creation from cart
- Order snapshot independent of product changes
- Order and OrderItem separation
- Supports order history per user

---

## Key Design Decisions

### Why Cart and Order are Separate
- Cart represents a **temporary shopping state**
- Order represents a **permanent business record**
- Prevents pricing and data inconsistencies

### Why OrderItem Does Not Reference Product
- Orders must survive product deletion
- Ensures historical accuracy
- Avoids breaking past orders when catalog changes

### Why `priceAtAddTime` Exists
- Product prices can change
- Cart and order prices must remain consistent
- Pricing is frozen at the time of user action

### Active vs Soft Delete
- `active = false` → temporarily unavailable
- `deleted = true` → permanently removed from lifecycle
- Deleted products never appear in cart or checkout

---

## Sample API Endpoints

### Auth
POST /auth/login
POST /auth/register

### Products
GET /products
POST /admin/products
PUT /admin/products/{id}
DELETE /admin/products/{id}

### Cart
GET /cart
POST /cart/items
PUT /cart/items/{itemId}
DELETE /cart/items/{itemId}
DELETE /cart

### Checkout & Orders
POST /checkout
POST /orders
GET /orders/my
GET /orders/{id}
