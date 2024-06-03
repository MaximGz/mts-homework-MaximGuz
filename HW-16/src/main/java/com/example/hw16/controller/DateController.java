package com.example.hw16.controller;

import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Задание 10: Использование @PathVariable с регулярными выражениями
@RestController
public class DateController {

    @GetMapping("/date/{date}")
    public ResponseEntity<String> getDate(@PathVariable String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return ResponseEntity.badRequest().body("Invalid date. Format: yyyy-MM-dd");
        }
        return ResponseEntity.ok("Valid date: " + date);
    }

}
