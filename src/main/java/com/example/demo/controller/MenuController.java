package com.example.demo.controller;

import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/")
    public String showMenuPage(ModelMap model) {
        model.addAttribute("menu", menuService.getMenu());
        return "thymeleaf/menu/menu";
    }

}