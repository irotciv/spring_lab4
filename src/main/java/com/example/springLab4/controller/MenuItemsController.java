package com.example.springLab4.controller;

import com.example.springLab4.entity.MenuItems;
import com.example.springLab4.service.MenuItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuItemsController {
    private final MenuItemsService menuItemsService;

    public MenuItemsController(MenuItemsService menuItemsService) {
        this.menuItemsService = menuItemsService;
    }

    @GetMapping("/menu-items")
    public String viewMenuItems(Model model) {
        model.addAttribute("menu", menuItemsService.getMenuItems());
        return "thymeleaf/menuItems/menuItems";
    }

    @GetMapping("/menu-items/new")
    public String addMenuItem(Model model) {
        MenuItems menuItem = new MenuItems();
        model.addAttribute("menuItem", menuItem);
        return "thymeleaf/menuItems/new";
    }

    @PostMapping("/menu-items/new")
    public String submitNewMenuItem(@ModelAttribute MenuItems menuItem) {
        menuItemsService.addNewMenuItem(menuItem);
        return "redirect:../menu-items/";
    }

    @GetMapping("/menu-items/delete")
    public String deleteMenuItem(@RequestParam Long id) {
        menuItemsService.deleteMenuItem(menuItemsService.getMenuItemById(id));
        return "redirect:../menu-items/";
    }
}
