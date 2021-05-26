package com.example.microservices.service_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class UserController {

    @RestController
    @RequestMapping("/user")
    public class UserController {
        @Autowired
        UserRepository userRepository;

        // Просмотр пользователя по id
        @GetMapping("")
        public ModelAndView user(@RequestParam(value = "userId", required = false) Long userId) {
            User user = userRepository.findById(userId).get();

            ModelAndView mv = new ModelAndView();
            mv.addObject("user", user);
            mv.setViewName("user/form");

            return mv;
        }

        // Просмотр всех пользователей
        @GetMapping("/list")
        public ModelAndView users() {
            Collection<User> users = (Collection<User>) userRepository.findAll();

            ModelAndView mv = new ModelAndView();
            mv.addObject("users", users);
            mv.setViewName("user/list");

            return mv;
        }

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
        }

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
        @DeleteMapping("/delete/{id}")
        public ModelAndView deleteUser(@PathVariable Long id) {
            User user = userRepository.findById(id).get();
            userRepository.delete(user);

            //-переадресация на страницу со списком сотрудников после удаления
            return new ModelAndView("redirect: list");
        }

}
