package animal.classifiers;

import animal.AbstractAnimal;

import java.time.LocalDate;

/**
 * Это родительский класс для всех домашних животных
 */
public abstract class Pet extends AbstractAnimal {
    public Pet() {
    }

    public Pet(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }
}
