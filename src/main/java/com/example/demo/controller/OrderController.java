package com.example.demo.controller;

import com.example.demo.entity.MenuItems;
import com.example.demo.entity.Order;
import com.example.demo.service.MenuItemsService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final MenuItemsService menuItemsService;

    @Autowired
    public OrderController(OrderService orderService, MenuItemsService menuItemsService) {
        this.orderService = orderService;
        this.menuItemsService = menuItemsService;
    }

    @GetMapping("/orders")
    public String showOrdersPage(ModelMap model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "thymeleaf/order/orders";
    }

    @GetMapping("/orders/complete")
    public String submitOrderCompletion(@RequestParam Long id) {
        orderService.submitOrderCompletion(id);
        return "redirect:../orders/";
    }

    @GetMapping("/orders/new")
    public String addNewOrder(Model model, @RequestParam Long id) {
        Order order = new Order();
        MenuItems menuItems = menuItemsService.getMenuItemById(id);
        model.addAttribute("order", order);
        model.addAttribute("menuItems", menuItems);
        return "thymeleaf/order/newOrder";
    }

    @PostMapping("/orders/new")
    public String submitNewOrder(@ModelAttribute Order order, @RequestParam Long id) {
        orderService.submitNewOrder(order, id);
        return "redirect:../orders/";
    }


}
