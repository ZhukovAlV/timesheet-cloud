package com.example.microservices.service_sample.controller;

import com.example.microservices.service_sample.entity.User;
import com.example.microservices.service_sample.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;

    // Просмотр пользователя по id
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        log.info("Find user by ID");
        User user = userService.findById(id).get();
        return user;
    }

   // Просмотр всех пользователей
   @GetMapping("/findAll")
   public List<User> findAllUser() {
       log.info("Find all users request");
       return userService.findAll();
   }
    // Сохраняем изменения пользователю
    @PutMapping("/save")
    public User saveUser(@ModelAttribute("user")User user) {
        return userService.save(user);
    }

    // Добавляем нового пользователя
    @PostMapping("/add")
    public User addUser(@ModelAttribute("user")User user) {
        return userService.save(user);
    }

    // Удаляем пользователя
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
