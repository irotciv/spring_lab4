package com.example.demo.service;

import com.example.demo.entity.MenuItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuItemsService {
    void submitNewMenuItem(MenuItems menuItem);
    MenuItems getMenuItemById(Long id);
    void deleteMenuItems(Long id);
    List<MenuItems> getMenuItems();
}
