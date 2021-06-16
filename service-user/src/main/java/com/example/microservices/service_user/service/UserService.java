package com.example.microservices.service_user.service;

import com.example.microservices.service_user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    void deleteById(Long userId);

    User findByLogin(String login);

    List<User> findAll();

    Optional<User> findById(Long id);
}
