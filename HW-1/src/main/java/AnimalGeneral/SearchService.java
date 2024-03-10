package AnimalGeneral;

import CustExecptions.InvalidAnimalBirthDateException;

/**
 * Интерфейс-сервис для поиска
 */
public interface SearchService {
    void checkLeapYearAnimal(Animal a) throws InvalidAnimalBirthDateException;
}
