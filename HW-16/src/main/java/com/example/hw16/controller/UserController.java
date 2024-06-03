package com.example.hw16.controller;

import com.example.hw16.dao.User;
import com.example.hw16.exception.CustomException;
import com.example.hw16.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    //Задание 2: Обработка POST-запросов
    @PostMapping
    public String userParams(@Valid @RequestBody User user) {
        return String.format("User %s with Email: %s registered successfully.", user.getName(), user.getEmail());
    }

    //Задание 5: Обработка исключений с помощью @ExceptionHandler
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        // Предположим, у нас есть условие, при котором пользователя с определенным id не существует
        if (id == 1) {
            throw new UserNotFoundException("User not found");
            //throw new IllegalArgumentException("User not found");
        }
        return "User found";
    }

    //Задание 6: Использование @RequestHeader
    @GetMapping("/uagent")
    public String getUserAgent(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }

    //Задание 9: Работа с @ResponseStatus
    @GetMapping("/exception")
    public String getUserException() {
        throw new CustomException("404 Not Found");
    }
}
