package com.example.hw16.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetController {
    @PostMapping
    public String greet(@RequestParam String name) {
        return "Hello " + name + "!";
    }
}
