package com.example.springLab4.entity;

import lombok.*;

import javax.validation.Valid;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private long id;
    @Valid
    private User user;
//    private List<MenuItems> menuItems;
//    @Valid
    private MenuItems menuItems;
//    private int price;

}
