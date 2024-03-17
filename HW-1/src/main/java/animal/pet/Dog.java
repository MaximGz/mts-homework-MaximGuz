package animal.pet;

import animal.classifiers.Pet;

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
}
