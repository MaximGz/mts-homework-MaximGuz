package com.example.hw16.advice;

import com.example.hw16.exception.CustomException;
import com.example.hw16.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    //Задание 5: Обработка исключений с помощью @ExceptionHandler
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUserNotFoundException(UserNotFoundException ex) {
        return ex.getMessage();
    }

    //Задание 7: Использование @ExceptionHandler для обработки исключений
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    //Задание 9: Работа с @ResponseStatus
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<String> handleCustomException(CustomException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emmm...Page not found");
//    }
}
