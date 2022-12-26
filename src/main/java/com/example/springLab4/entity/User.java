package com.example.springLab4.entity;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
//    private Long id;
    private String email;
    private String password;
    @NotNull
    @Size(min = 1)
    private String firstName;
    @NotNull
    @Size(min = 1)
    private String lastName;

}
