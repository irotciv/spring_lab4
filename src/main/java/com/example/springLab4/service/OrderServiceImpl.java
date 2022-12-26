package com.example.springLab4.service;

import com.example.springLab4.entity.MenuItems;
import com.example.springLab4.entity.Order;
import com.example.springLab4.repository.MenuItemsRepository;
import com.example.springLab4.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
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
    public Order getOrderById(Long id) {
        return fakeOrderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Order order) {
        fakeOrderRepository.getOrders().remove(order);
    }

    @Override
    public Order addNewOrder(Order order, Long id) {
        List<Order> ordersList = fakeOrderRepository.getOrders();
        order.setId(ordersList.get(ordersList.size() - 1).getId() + 1);
        order.setMenuItems(fakeMenuItemsRepository.getMenuItems().get(
                fakeMenuItemsRepository.getMenuItems().indexOf(fakeMenuItemsRepository.findById(id))
        ));
        fakeOrderRepository.getOrders().add(order);
        return getAllOrders().get(getAllOrders().size() - 1);
    }
}
