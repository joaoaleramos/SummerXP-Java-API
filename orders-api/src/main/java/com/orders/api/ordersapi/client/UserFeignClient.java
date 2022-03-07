package com.orders.api.ordersapi.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-client", url = "http://localhost:8989/users/")
public interface UserFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable UUID id);
}
