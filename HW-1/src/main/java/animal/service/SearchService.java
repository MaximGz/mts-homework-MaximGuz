package animal.service;

import animal.Animal;
import custexceptions.InvalidAnimalBirthDateException;

/**
 * Интерфейс-сервис для поиска
 */
public interface SearchService {
    void checkLeapYearAnimal(Animal a) throws InvalidAnimalBirthDateException;
}
