package com.example.demo.service;


import com.example.demo.entity.MenuItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    List<MenuItems> getMenu();
}
