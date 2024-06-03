package com.example.hw16.controller;

import com.example.hw16.dao.GreetData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetController {
    @PostMapping
    public String greet(@RequestBody GreetData g) {
        return "Hello " + g.getName() + "!";
    }
}
