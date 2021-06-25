package com.example.microservices.service_user.controller;

import com.example.microservices.service_user.entity.User;
import com.example.microservices.service_user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@AllArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;

    // Просмотр пользователя по id
    @GetMapping("/{userId}")
    public Optional<User> findById(@PathVariable Long userId) {
        log.info("Find user by ID");
        return userService.findById(userId);
    }

   // Просмотр всех пользователей
   @GetMapping("")
   public Iterable<User> findAll() {
       log.info("Find all users request");
       return userService.findAll();
   }

    // Сохраняем изменения пользователю
    @PutMapping("")
    public User updateUser(@RequestBody User user) {
        log.info("Update user by " + user.getUserId());
        return userService.save(user);
    }

    // Добавляем нового пользователя
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        log.info("Add user");
        return userService.save(user);
    }

    // Удаляем пользователя
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        log.info("Delete user by ID");
        if (userService.findById(userId).isPresent()) {
            userService.deleteById(userId);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }
}
