package com.products.api.productsapi.controller;

import java.util.UUID;

import com.products.api.productsapi.model.Product;
import com.products.api.productsapi.service.ProductService;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/")
    public ResponseEntity<Object> getProducts() {
        return ResponseEntity.ok().body(productService.getAlProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable UUID id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    @PostMapping("/")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID id, @RequestBody Product product) {
        return ResponseEntity.ok().body(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
