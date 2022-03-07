package com.products.api.productsapi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.products.api.productsapi.model.Product;
import com.products.api.productsapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getProducts() {
        return ResponseEntity.ok().body(productService.getAlProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable UUID id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    @PostMapping("/post/")
    public ResponseEntity<Object> addProduct(@RequestBody @Valid Product product) {
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
