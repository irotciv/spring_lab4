package com.example.demo.service;

import com.example.demo.entity.MenuItems;
import com.example.demo.repository.MenuRepository;
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
