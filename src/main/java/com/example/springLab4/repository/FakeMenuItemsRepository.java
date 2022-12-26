package com.example.springLab4.repository;

import com.example.springLab4.entity.MenuItems;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class FakeMenuItemsRepository implements MenuItemsRepository {
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
    public List<MenuItems> findAll(Integer price, String description) {
        List<MenuItems> menuItems = new ArrayList<>();
        for (MenuItems menuItem : getMenuItems()) {
            if (description == null && menuItem.getPrice().equals(price)) {
                menuItems.add(menuItem);
            }
            if (description != null && price == null && menuItem.getDescription().contains(description)) {
                menuItems.add(menuItem);
            }
            if ((description != null && menuItem.getDescription().contains(description))
                    && (menuItem.getPrice().equals(price))) {
                menuItems.add(menuItem);
            }
        }
        if (price == null && description == null)
            return getMenuItems();
        return menuItems;
    }

    @Override
    public List<MenuItems> findPaginated(Integer price, String description, Integer page, Integer size) {
        List<MenuItems> menuItems = findAll(price, description);
        int startIndex = page * size;
        int endIndex = page * size + size;
        if (startIndex > menuItems.size() || endIndex > menuItems.size()) {
            startIndex = Math.min(startIndex, menuItems.size());
            endIndex = menuItems.size();
        }
        return menuItems.subList(startIndex, endIndex);
    }

    @Override
    public List<MenuItems> getMenuItems() {
        return menuItems;
    }
}
