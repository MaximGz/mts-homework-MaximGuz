package org.starter.pet;

import org.starter.classifiers.Pet;

import java.time.LocalDate;
import java.util.Random;

/**
 * Класс для создания кота
 */
public class Cat extends Pet {
    public Cat() {
    }

    public Cat(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }
    public Cat(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        super(name, breed, cost, character, birthDate, secretInformation);
    }
}
