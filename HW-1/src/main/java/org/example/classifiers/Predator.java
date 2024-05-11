package org.example.classifiers;

import org.starter.AbstractAnimal;

import java.time.LocalDate;

/**
 * Это родительский класс для всех хищных животных
 */
public abstract class Predator extends AbstractAnimal {
    public Predator() {
    }

    public Predator(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }

    public Predator(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        super(name, breed, cost, character, birthDate, secretInformation);
    }
}
