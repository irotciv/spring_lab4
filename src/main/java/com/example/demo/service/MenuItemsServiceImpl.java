package com.example.demo.service;

import com.example.demo.entity.MenuItems;
import com.example.demo.repository.MenuItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemsServiceImpl implements MenuItemsService {
    private final MenuItemsRepository fakeMenuItemsRepository;

    @Autowired
    public MenuItemsServiceImpl(MenuItemsRepository fakeMenuItemsRepository) {
        this.fakeMenuItemsRepository = fakeMenuItemsRepository;
    }

    @Override
    public MenuItems getMenuItemById(Long id) {
        return fakeMenuItemsRepository.findById(id);
    }

    @Override
    public void submitNewMenuItem(MenuItems menuItem) {
        List<MenuItems> menuItemsList = fakeMenuItemsRepository.getMenuItems();
        menuItem.setId(menuItemsList.get(menuItemsList.size() - 1).getId() + 1);
        fakeMenuItemsRepository.getMenuItems().add(menuItem);
    }

    @Override
    public void deleteMenuItems(Long id) {
        fakeMenuItemsRepository.getMenuItems().remove(fakeMenuItemsRepository.findById(id));
    }

    @Override
    public List<MenuItems> getMenuItems() {
        return fakeMenuItemsRepository.getMenuItems();
    }
}
