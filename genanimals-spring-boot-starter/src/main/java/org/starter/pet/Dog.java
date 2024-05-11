package org.starter.pet;

import org.starter.classifiers.Pet;

import java.time.LocalDate;

/**
 * Класс для создания собаки
 */
public class Dog extends Pet {
    public Dog() {
    }

    public Dog(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }

    public Dog(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        super(name, breed, cost, character, birthDate, secretInformation);
    }
}
