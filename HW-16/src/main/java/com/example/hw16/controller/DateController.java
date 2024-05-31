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
    public ResponseEntity<String> getDate(@PathVariable @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Not valid") String date) {
        return ResponseEntity.ok("Valid date: " + date);
    }

}
