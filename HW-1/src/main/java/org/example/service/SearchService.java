package org.example.service;

import org.starter.Animal;
import org.example.custexceptions.InvalidAnimalBirthDateException;

/**
 * Интерфейс-сервис для поиска
 */
public interface SearchService {
    void checkLeapYearAnimal(Animal a) throws InvalidAnimalBirthDateException;
}
