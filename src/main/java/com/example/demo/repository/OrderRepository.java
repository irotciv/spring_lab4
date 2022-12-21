package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    Order findById(Long id);
    List<Order> getOrders();
}
