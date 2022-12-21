package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.repository.MenuItemsRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository fakeOrderRepository;
    private final MenuItemsRepository fakeMenuItemsRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository fakeOrderRepository, MenuItemsRepository fakeMenuItemsRepository) {
        this.fakeOrderRepository = fakeOrderRepository;
        this.fakeMenuItemsRepository = fakeMenuItemsRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return fakeOrderRepository.getOrders();
    }

    @Override
    public void submitOrderCompletion(Long id) {
        fakeOrderRepository.getOrders().remove(fakeOrderRepository.findById(id));
    }

    @Override
    public void submitNewOrder(Order order, Long id) {
        List<Order> ordersList = fakeOrderRepository.getOrders();
        order.setId(ordersList.get(ordersList.size() - 1).getId() + 1);
        order.setMenuItems(fakeMenuItemsRepository.getMenuItems().get(
                fakeMenuItemsRepository.getMenuItems().indexOf(fakeMenuItemsRepository.findById(id))
        ));
        fakeOrderRepository.getOrders().add(order);
    }
}
