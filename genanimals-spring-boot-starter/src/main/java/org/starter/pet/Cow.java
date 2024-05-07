package org.starter.pet;

import org.starter.classifiers.Pet;

import java.time.LocalDate;

/**
 * Класс для создания коровы
 */
public class Cow extends Pet {
    public Cow() {
    }

    public Cow(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }

    public Cow(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        super(name, breed, cost, character, birthDate, secretInformation);
    }
}
