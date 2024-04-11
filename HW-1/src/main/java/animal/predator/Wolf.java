package animal.predator;

import animal.classifiers.Predator;

import java.time.LocalDate;

/**
 * Класс для создания волка
 */
public class Wolf extends Predator {
    public Wolf() {
    }

    public Wolf(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }

    public Wolf(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        super(name, breed, cost, character, birthDate, secretInformation);
    }
}
