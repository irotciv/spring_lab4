package com.example.demo.controller;

import com.example.demo.entity.MenuItems;
import com.example.demo.service.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuItemsController {
    private final MenuItemsService menuItemsService;

    @Autowired
    public MenuItemsController(MenuItemsService menuItemsService) {
        this.menuItemsService = menuItemsService;
    }

    @GetMapping("/menuItems")
    public String viewMenuItems(Model model) {
        model.addAttribute("menu", menuItemsService.getMenuItems());
        return "thymeleaf/menuItems/menuItems";
    }

    @GetMapping("/menuItems/new")
    public String addMenuItem(Model model) {
        MenuItems menuItem = new MenuItems();
        model.addAttribute("menuItem", menuItem);
        return "thymeleaf/menuItems/new";
    }

    @PostMapping("/menuItems/new")
    public String submitNewRoom(@ModelAttribute MenuItems menuItem) {
        menuItemsService.submitNewMenuItem(menuItem);
        return "redirect:../menuItems/";
    }

    @GetMapping("/menuItems/delete")
    public String deleteRoom(@RequestParam Long id) {
        menuItemsService.deleteMenuItems(id);
        return "redirect:../menuItems/";
    }
}
