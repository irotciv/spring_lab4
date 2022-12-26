package com.example.springLab4.service;

import com.example.springLab4.entity.MenuItems;
import com.example.springLab4.repository.MenuItemsRepository;
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
    public MenuItems addNewMenuItem(MenuItems menuItem) {
        List<MenuItems> menuItemsList = fakeMenuItemsRepository.getMenuItems();
        menuItem.setId(menuItemsList.get(menuItemsList.size() - 1).getId() + 1);
        fakeMenuItemsRepository.getMenuItems().add(menuItem);
        return menuItem;
    }

    @Override
    public MenuItems updateMenuItem(MenuItems oldMenuItem, MenuItems menuItem) {
        int index = fakeMenuItemsRepository.getMenuItems().indexOf(oldMenuItem);
        fakeMenuItemsRepository.getMenuItems().set(index, menuItem);
        return fakeMenuItemsRepository.getMenuItems().get(index);
    }

    @Override
    public boolean deleteMenuItem(MenuItems menuItem) {
        return fakeMenuItemsRepository.getMenuItems().remove(menuItem);
    }

    @Override
    public List<MenuItems> getMenuItems() {
        return fakeMenuItemsRepository.getMenuItems();
    }

    @Override
    public List<MenuItems> findAll(Integer price, String description) {
        return fakeMenuItemsRepository.findAll(price, description);
    }

    @Override
    public List<MenuItems> findPaginated(Integer price, String description, Integer page, Integer size) {
        return fakeMenuItemsRepository.findPaginated(price, description, page, size);
    }
}
