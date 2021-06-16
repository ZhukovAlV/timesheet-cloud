package com.example.microservices.service_timesheet.service;

import com.example.microservices.service_timesheet.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    void deleteById(Long userId);

    User findByLogin(String login);

    List<User> findAll();

    Optional<User> findById(Long id);
}
