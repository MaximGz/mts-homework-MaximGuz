package com.example.hw15.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "animal")
public class Animal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private Double cost;
    private String character;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType type;

    public Animal(String name, String breed, Double cost, String character, LocalDate birthDate, AnimalType type) {
        this.name = name;
        this.breed = breed;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
        this.type = type;
    }

    public Animal(Long id, String name, String breed, Double cost, String character, LocalDate birthDate, AnimalType type) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
        this.type = type;
    }
}
