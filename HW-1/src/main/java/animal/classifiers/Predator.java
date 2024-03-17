package animal.classifiers;

import animal.AbstractAnimal;

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
}
