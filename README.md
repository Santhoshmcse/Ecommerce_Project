# Ecommerce Backend Service

## Overview
A Spring Boot–based ecommerce backend demonstrating
clean architecture, JPA domain modeling, and transactional order handling.

## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Core Modules
- User & Authentication
- Product Catalog
- Cart Management
- Order & Order Items

## Domain Design
- Order → OrderItem (One-to-Many)
- BaseEntity for shared fields
- DTO-based API design (no entity exposure)

## Current Status
- Domain models created
- JPA repositories implemented
- Database schema auto-generated using Hibernate

## Upcoming
- Service layer (business logic)
- REST controllers
- Security (JWT)
