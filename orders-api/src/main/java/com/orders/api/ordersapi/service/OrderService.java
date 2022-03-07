package com.orders.api.ordersapi.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.orders.api.ordersapi.client.ProductFeignClient;
import com.orders.api.ordersapi.client.UserFeignClient;
import com.orders.api.ordersapi.model.Order;
import com.orders.api.ordersapi.model.Product;
import com.orders.api.ordersapi.repository.OrderRepository;
import java.util.UUID;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserFeignClient userFeignClient;

    @Autowired
    ProductFeignClient productFeignClient;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(UUID id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(UUID id, Order order) {
        Order actualOrder = orderRepository.getById(id);
        BeanUtils.copyProperties(order, actualOrder, "id");
        return orderRepository.save(actualOrder);
    }

    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    public Object verifyUser(UUID id) {
        return userFeignClient.getUser(id).getBody();
    }

    public BigDecimal getPrices(UUID[] ids) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0; i < ids.length; i++) {
            Product product = productFeignClient.getProduct(ids[i]).getBody();
            totalPrice = totalPrice.add(product.getPrice());

        }
        return totalPrice;
    }
}
