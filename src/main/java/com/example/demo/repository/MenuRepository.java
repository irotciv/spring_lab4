package com.example.demo.repository;

import com.example.demo.entity.MenuItems;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository {
    List<MenuItems> getMenu();
}
