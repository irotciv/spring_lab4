package com.example.springLab4.repository;

import com.example.springLab4.entity.MenuItems;

import java.util.List;

public interface MenuRepository {
    List<MenuItems> getMenu();
}
