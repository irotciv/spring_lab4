package com.example.springLab4.repository;

import com.example.springLab4.entity.MenuItems;

import java.util.List;

public interface MenuItemsRepository {
    MenuItems findById(Long id);
    List<MenuItems> getMenuItems();
    List<MenuItems> findAll(Integer price, String description);
    List<MenuItems> findPaginated(Integer price, String description, Integer page, Integer size);
}
