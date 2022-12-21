package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItems {
    private long id;
    private String name;
    private String description;
    private int price;

}
