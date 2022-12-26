package com.example.springLab4.entity;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItems {
    private Long id;
    @NotNull
    @Size(min = 1)
    private String name;
    @NotNull
    @Size(min = 1)
    private String description;
    @NotNull
    @Min(1)
    private Integer price;

}
