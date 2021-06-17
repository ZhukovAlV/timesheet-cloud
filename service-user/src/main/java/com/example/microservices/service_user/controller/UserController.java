package com.example.microservices.service_user.controller;

import com.example.microservices.service_user.entity.User;
import com.example.microservices.service_user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
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
   @GetMapping("/all")
   public List<User> findAll() {
       log.info("Find all users request");
       return userService.findAll();
   }
    // Сохраняем изменения пользователю
    @PutMapping("/update")
    public User updateUser(@ModelAttribute("user")User user) {
        log.info("Update user");
        return userService.save(user);
    }

    // Добавляем нового пользователя
    @PostMapping("/add")
    public User addUser(@ModelAttribute("user")User user) {
        log.info("Add user");
        return userService.save(user);
    }

    // Удаляем пользователя
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable Long id) {
        log.info("Delete user by ID");
        userService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
