package com.example.demo.repository;

import com.example.demo.entity.MenuItems;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemsRepository {
    MenuItems findById(Long id);
    List<MenuItems> getMenuItems();
}
