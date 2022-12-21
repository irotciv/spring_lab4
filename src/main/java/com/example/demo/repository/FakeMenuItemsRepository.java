package com.example.demo.repository;

import com.example.demo.entity.MenuItems;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class FakeMenuItemsRepository implements MenuItemsRepository{
    private final List<MenuItems> menuItems = new ArrayList<>();

    public FakeMenuItemsRepository() {
        menuItems.add(new MenuItems(0L, "Dessert 1", "milk, eggs, sugar, chocolate", 200));
        menuItems.add(new MenuItems(1L, "Dessert 2", "milk, eggs, sugar, strawberry", 300));
    }

    @Override
    public MenuItems findById(Long id) {
        return menuItems.stream().filter(menuItem -> id.equals(menuItem.getId())).findAny().orElse(null);
    }

    @Override
    public List<MenuItems> getMenuItems() {
        return menuItems;
    }
}
