package com.example.springLab4.service;


import com.example.springLab4.entity.MenuItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    List<MenuItems> getMenu();
}
