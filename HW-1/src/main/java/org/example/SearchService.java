package org.example;

import org.example.custexceptions.InvalidAnimalBirthDateException;
import org.starter.Animal;

/**
 * Интерфейс-сервис для поиска
 */
public interface SearchService {
    void checkLeapYearAnimal(Animal a) throws InvalidAnimalBirthDateException;
}
