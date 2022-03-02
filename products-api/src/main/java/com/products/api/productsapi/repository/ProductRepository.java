package com.products.api.productsapi.repository;

import java.util.UUID;

import com.products.api.productsapi.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
