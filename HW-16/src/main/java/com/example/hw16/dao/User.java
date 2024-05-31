package com.example.hw16.dao;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


//Задание 3: Валидация данных
@Builder
@Data
public class User {
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 20)
    private String name;

    @Email(message = "Неверный формат email")
    @NotEmpty(message = "email не должно быть пустым")
    private String email;
}
