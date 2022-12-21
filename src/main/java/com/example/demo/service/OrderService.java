package com.example.demo.service;

import com.example.demo.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    void submitOrderCompletion(Long id);
//    Order getOrderById(Long id);
//    void submitEditedOrder(Order order, Long id);
    void submitNewOrder(Order order, Long id);
}
