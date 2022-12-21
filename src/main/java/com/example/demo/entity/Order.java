package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private long id;
    private User user;
//    private List<MenuItems> menuItems;
    private MenuItems menuItems;
//    private int price;

}
