package com.example.springLab4.service;

import com.example.springLab4.entity.User;
import com.example.springLab4.pojo.UserRegistrationRequest;
import com.example.springLab4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, Object> processRegister(UserRegistrationRequest request) {
        Map<String, Object> result = new HashMap<>();
        if (userRepository.findByEmail(request.getEmail()) != null) {
            result.put("message_number", 1);
            result.put("msg", "Користувач з такою поштою вже зареєстрований.");
            result.put("link", "/registration");
            result.put("text", "Натисніть, щоб спробувати ще раз");
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(request.getPassword());
            User user = new User();
            user.setEmail(request.getEmail());
            user.setPassword(encodedPassword);
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());

            userRepository.getUsers().add(user);
            result.put("message_number", 0);
            result.put("msg", "Ви успішно зареєстровані!");
            result.put("link", "/login");
            result.put("text", "Натисніть, щоб продовжити");
        }
        return result;
    }
}
