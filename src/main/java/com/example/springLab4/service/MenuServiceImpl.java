package com.example.springLab4.service;

import com.example.springLab4.entity.MenuItems;
import com.example.springLab4.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository fakeMenuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository fakeMenuRepository) {
        this.fakeMenuRepository = fakeMenuRepository;
    }

    @Override
    public List<MenuItems> getMenu() {
        return fakeMenuRepository.getMenu();
    }

}
