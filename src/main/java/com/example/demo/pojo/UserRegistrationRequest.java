package com.example.demo.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}