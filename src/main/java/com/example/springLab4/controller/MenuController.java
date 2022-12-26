package com.example.springLab4.controller;

import com.example.springLab4.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/")
    public String showMenuPage(ModelMap model) {
        model.addAttribute("menu", menuService.getMenu());
        return "thymeleaf/menu/menu";
    }

}