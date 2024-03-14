package animal.service;

import animal.AbstractAnimal;
import animal.pet.Cat;
import animal.pet.Cow;
import animal.pet.Dog;
import animal.predator.Lion;
import animal.predator.Shark;
import animal.predator.Wolf;

import java.time.LocalDate;
import java.util.Random;

public class HelperService {
    /**
     * Метод для создания рандомного животного
     *
     * @param randomAnimal - экзмепляр животного, представленный в числовом формате
     * @return - новый объект животного
     */
    public static AbstractAnimal switchAnimal(int randomAnimal) {
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
            default:
                return null;
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
