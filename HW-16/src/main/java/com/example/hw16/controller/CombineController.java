package com.example.hw16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Задание 4: Использование @RequestParam и @PathVariable
@RestController
public class CombineController {
    @GetMapping("/combine/{name}")
    public String combineParams(@PathVariable String name, @RequestParam int id) {
        return "Hello, " + name + "! Your id is " + id;
    }
}
