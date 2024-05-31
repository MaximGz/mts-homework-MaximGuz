package com.example.hw16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// Задание 11: Использование @RequestParam с параметрами по умолчанию
@RestController
public class DefaultController {
    @GetMapping("/def")
    @ResponseBody
    public String getDef(@RequestParam(defaultValue = "Guest") String name) {
        return "Hi " + name + "!";
    }
}
