package com.example.microservices.service_sample.controller;

import com.example.microservices.service_sample.entity.User;
import com.example.microservices.service_sample.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;

    // Просмотр пользователя по id
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
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
/*
    // Сохраняем изменения пользователю
    @PostMapping("/save")
    public ModelAndView saveUser(@ModelAttribute("user")User user) {
        userRepository.save(user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user/form");

        return mv;
    }

    // Отображаем форму для заведения нового пользователя
    @GetMapping("/new")
    public ModelAndView showFormUserNew() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/new");

        return mv;
    }

    // Добавляем нового пользователя
    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute("user")User user) {
        userRepository.save(user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user/new");

        return mv;
    }*/

        // Удаляем пользователя
    /*
    @GetMapping("/delete")
    public ModelAndView deleteUser(@RequestParam(value = "userId", required = false) Long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);

        //-переадресация на страницу со списком сотрудников после удаления
        return new ModelAndView("redirect: list");
    }
     */
/*        @DeleteMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);

        //-переадресация на страницу со списком сотрудников после удаления
        return new ModelAndView("redirect: list");
    }*/
}
