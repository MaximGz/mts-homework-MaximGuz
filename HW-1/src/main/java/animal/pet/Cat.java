package animal.pet;

import animal.classifiers.Pet;

import java.time.LocalDate;

/**
 * Класс для создания кота
 */
public class Cat extends Pet {
    public Cat() {
    }

    public Cat(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }
}
