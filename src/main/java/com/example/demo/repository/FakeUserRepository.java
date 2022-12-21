package com.example.demo.repository;

import com.example.demo.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class FakeUserRepository implements UserRepository{
    private final List<User> users = new ArrayList<>();

    public FakeUserRepository() {
        users.add(new User("john@gmail.com", "$2a$08$UnToTL1tsdZijK.nKaGeFO6nNtHlznJWBf.izk48yAeuBQagogj3i", "John", "Bill"));
        users.add(new User("bob@gmail.com", "$2a$08$F8cSKAN16de8rbe5V6zbUOBmGQXGd3Im3fAAUOk4fqEMp4B6EeyPi", "Bob", "Brown"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User findByEmail(String email) {
        return users.stream().filter(user -> email.equals(user.getEmail())).findAny().orElse(null);
    }
}
