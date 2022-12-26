package com.example.springLab4.service;

import com.example.springLab4.entity.MenuItems;
import com.example.springLab4.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();

    void deleteOrder(Order order);

    Order getOrderById(Long id);

    Order addNewOrder(Order order, Long id);
}
