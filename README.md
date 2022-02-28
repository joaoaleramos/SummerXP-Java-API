# SummerXP-Java-API

## Introduction

### What this Project is about

In this project, we will be creating microservices that will be represented for four different entities, which will work together to provide a complete solution for a sales management system.

## Entities

### User

The user entity represents a user of the system. It will have the following attributes with the following types:

-id: UUID
-name: String
-email: String
-CPF: String (Unique)
-Postal Code: String
-Address: String

### Products

The products entity represents the products of the system. It will have the following attributes with the following types:

-id:UUID
-name: String
-value: BigDecimal

### Payment

The payment entity represents the payments of the system. It will have the following attributes with the following types:

-id: UUID
-user name: String
-value: BigDecimal
-Card number : String
-Security code: String
-Expiration date: String
-products: List of Products

### Orders

The orders entity represents an order of the system. It will have the following attributes with the following types:

-id: UUID
-products: List of products
-user: Users
