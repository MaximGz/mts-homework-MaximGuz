package animal.predator;

import animal.classifiers.Predator;

import java.time.LocalDate;

/**
 * Класс для создания акулы
 */
public class Shark extends Predator {
    public Shark() {
    }

    public Shark(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }
}
