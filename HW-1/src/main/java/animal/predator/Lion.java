package animal.predator;

import animal.classifiers.Predator;

import java.time.LocalDate;

/**
 * Класс для создания льва
 */
public class Lion extends Predator {
    public Lion() {
    }

    public Lion(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(name, breed, cost, character, birthDate);
    }
    public Lion(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        super(name, breed, cost, character, birthDate, secretInformation);
    }

}
