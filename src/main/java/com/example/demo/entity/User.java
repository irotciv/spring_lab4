package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
//    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
