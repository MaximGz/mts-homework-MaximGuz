package com.example.hw16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Задание 1: Создание простого контроллера
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String getHelloWorld() {
        return "Hello World";
    }

}
