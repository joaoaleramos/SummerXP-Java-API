package com.orders.api.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

import com.orders.api.ordersapi.model.Order;
import com.orders.api.ordersapi.model.Payment;
import com.orders.api.ordersapi.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrder());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable UUID id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @PostMapping("/post/")
    public ResponseEntity<Object> saveOrder(@RequestBody Order order) {
        orderService.getPrices(order.getProductIDs());
        if (orderService.verifyUser(order.getUserID()) == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This user doesn't exist");
        }
        if (!orderService.verifyPayment(order.getPayment(), order.getProductIDs())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Payment not authorized");
        }
        return ResponseEntity.ok().body(orderService.saveOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") UUID id, @RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.updateOrder(id, order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
