package com.example.springLab4.repository;

import com.example.springLab4.entity.MenuItems;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Getter
@Setter
public class FakeMenuRepository implements MenuRepository {
    private MenuItemsRepository fakeMenuItemsRepository;

    public FakeMenuRepository(MenuItemsRepository fakeMenuItemsRepository) {
        this.fakeMenuItemsRepository = fakeMenuItemsRepository;
    }

    @Override
    public List<MenuItems> getMenu() {
        return fakeMenuItemsRepository.getMenuItems();
    }
}
