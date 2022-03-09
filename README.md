# SummerXP-Java-API

## Introduction

### What this Project is about

In this project, we will be creating microservices that will be represented for four different entities, which will work together to provide a complete solution for a sales management system.

## Entities

### User

The user entity represents a user of the system. It will have the following attributes with the following types:

- id: UUID
- name: String
- email: String
- CPF: String (Unique)
- Postal Code: String
- Address: String
- Birth Date: Date

### Products

The products entity represents the products of the system. It will have the following attributes with the following types:

- id:UUID
- name: String
- price: BigDecimal

### Payment

The payment entity represents the payments of the system. It will have the following attributes with the following types:

- id: UUID
- value: BigDecimal
- Card number : String
- CVV: String
- Expiration date: String
- Owner: String

### Orders

The orders entity represents an order of the system. It will have the following attributes with the following types:

- id: UUID
- productIds: List of UUID
- userId: UUID
- payment: Payment

## Start Project
