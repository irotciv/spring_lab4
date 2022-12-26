package com.example.springLab4.repository;

import com.example.springLab4.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers();
    User findByEmail(String email);
}
