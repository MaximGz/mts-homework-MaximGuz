package AnimalGeneral;

import CustExecptions.InvalidAnimalBirthDateException;
import CustExecptions.InvalidAnimalException;
import PetAnimals.*;
import PredatorAnimals.*;

import java.time.LocalDate;
import java.util.Random;

/**
 * Класс-сервис для работы с Animal
 */
public class CreateAnimalService {
    /**
     * Метод для создания 10 рандомных животных
     */
    public void createAnimals() throws InvalidAnimalBirthDateException {
        int count = 0;
        SearchServiceImpl ssi = new SearchServiceImpl();
        while (count < 10) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal animal = switchAnimal(randomAnimal);

            animal.name = "Animals.Animal" + count;
            animal.breed = "Breed" + count;
            animal.cost = Math.random() * 10000;
            animal.character = "Character" + count;
            animal.birthDate = generateRandomDate();

            System.out.println(animal);

            try {
                ssi.checkLeapYearAnimal(animal);
            } catch (NullPointerException e) {
                throw new InvalidAnimalException();
            }
            count++;
        }
    }

    /**
     * Метод для создания рандомного животного
     * @param randomAnimal - экзмепляр животного, представленный в числовом формате
     * @return - новый объект животного
     */
    public AbstractAnimal switchAnimal(int randomAnimal) {
        switch (randomAnimal) {
            case 0:
                return new Dog();
            case 1:
                return new Cat();
            case 2:
                return new Cow();
            case 3:
                return new Wolf();
            case 4:
                return new Shark();
            case 5:
                return new Lion();
            default: return null;
        }
    }

    /**
     * Статический метод для генерации рандомной даты
     */
    public static LocalDate generateRandomDate() {
        Random random = new Random();

        long startDate = LocalDate.of(1900, 1, 1).toEpochDay(); //Начальная дата
        long endDate = LocalDate.of(2022, 12, 31).toEpochDay(); //Конечная дата

        long randomDay = startDate + random.nextInt((int) (endDate - startDate));

        return LocalDate.ofEpochDay(randomDay);
    }
}
