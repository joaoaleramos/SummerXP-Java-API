package com.orders.api.ordersapi.repository;

import java.util.UUID;

import com.orders.api.ordersapi.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
