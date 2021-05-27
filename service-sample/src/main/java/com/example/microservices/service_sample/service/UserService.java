package com.example.microservices.service_sample.service;

import com.example.microservices.service_sample.entity.User;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

public interface UserService {
    User saveUser(User usersDto) throws ValidationException, TimeoutException;

    void deleteUser(Integer userId);

    User findByLogin(String login);

    List<User> findAll();

    Optional<User> findById(Integer id);
}
