package com.example.hw16.controller;

import com.example.hw16.dao.GreetRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {
    @PostMapping
    public String greet(@RequestBody GreetRequest request) {
        return "Hello " + request.getName() + "!";
    }
}
