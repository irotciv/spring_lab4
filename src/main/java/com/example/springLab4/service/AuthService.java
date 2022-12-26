package com.example.springLab4.service;

import com.example.springLab4.pojo.UserRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AuthService {
    Map<String, Object> processRegister(UserRegistrationRequest request);
}
