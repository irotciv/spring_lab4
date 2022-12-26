package com.example.springLab4.repository;

import com.example.springLab4.entity.Order;

import java.util.List;

public interface OrderRepository {
    Order findById(Long id);
    List<Order> getOrders();
}
