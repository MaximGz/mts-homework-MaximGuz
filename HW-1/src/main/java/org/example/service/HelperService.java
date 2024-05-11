package org.example.service;

import org.starter.AbstractAnimal;
import org.starter.pet.Cat;
import org.starter.pet.Cow;
import org.starter.pet.Dog;
import org.starter.predator.Lion;
import org.starter.predator.Shark;
import org.starter.predator.Wolf;

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
     * Метод для генерации рандомной даты
     */
    public static LocalDate generateRandomDate() {
        Random random = new Random();

        long startDate = LocalDate.of(1900, 1, 1).toEpochDay(); //Начальная дата
        long endDate = LocalDate.of(2022, 12, 31).toEpochDay(); //Конечная дата

        long randomDay = startDate + random.nextInt((int) (endDate - startDate));

        return LocalDate.ofEpochDay(randomDay);
    }
}
