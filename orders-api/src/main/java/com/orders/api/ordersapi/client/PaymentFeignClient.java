package com.orders.api.ordersapi.client;

import com.orders.api.ordersapi.model.Payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-client", url = "http://localhost:8989/payment/")
public interface PaymentFeignClient {

    @PostMapping("/post/")
    public ResponseEntity<Object> savePayment(@RequestBody Payment payment);

}
