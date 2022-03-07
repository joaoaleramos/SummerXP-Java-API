package com.orders.api.ordersapi.client;

import java.util.UUID;

import com.orders.api.ordersapi.model.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-client", url = "http://localhost:8989/products/")
public interface ProductFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable UUID id);
}
