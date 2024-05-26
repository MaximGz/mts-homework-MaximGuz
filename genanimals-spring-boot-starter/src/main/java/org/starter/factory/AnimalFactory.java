package org.starter.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.starter.AbstractAnimal;
import org.starter.pet.Cat;
import org.starter.pet.Cow;
import org.starter.pet.Dog;
import org.starter.predator.Lion;
import org.starter.predator.Shark;
import org.starter.predator.Wolf;
import org.starter.service.FileAnimalsService;
import org.starter.service.NamesListService;
import org.starter.service.PathsPropertyService;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class AnimalFactory {
    @Autowired
    NamesListService namesListService;
    @Autowired
    FileAnimalsService fileAnimalsService;

    public AbstractAnimal switchAnimal(int randomAnimal, int count) {
        switch (randomAnimal) {
            case 0: {
                List<String> listNames = namesListService.getDogNames();
                int r = (int) (Math.random() * listNames.size());
                return new Dog(listNames.get(r),"Breed" + count, Math.random() * 10000,
                        "Character" + count, generateRandomDate(), fileAnimalsService.getSecretCodeFromFile());
            }
            case 1: {
                List<String> listNames = namesListService.getCatNames();
                int r = (int) (Math.random() * listNames.size());
                return new Cat(listNames.get(r),"Breed" + count, Math.random() * 10000,
                        "Character" + count, generateRandomDate(), fileAnimalsService.getSecretCodeFromFile());
            }
            case 2: {
                List<String> listNames = namesListService.getCowNames();
                int r = (int) (Math.random() * listNames.size());
                return new Cow(listNames.get(r),"Breed" + count, Math.random() * 10000,
                        "Character" + count, generateRandomDate(), fileAnimalsService.getSecretCodeFromFile());
            }
            case 3: {
                List<String> listNames = namesListService.getWolfNames();
                int r = (int) (Math.random() * listNames.size());
                return new Wolf(listNames.get(r),"Breed" + count, Math.random() * 10000,
                        "Character" + count, generateRandomDate(), fileAnimalsService.getSecretCodeFromFile());
            }
            case 4: {
                List<String> listNames = namesListService.getSharkNames();
                int r = (int) (Math.random() * listNames.size());
                return new Shark(listNames.get(r),"Breed" + count,
                        Math.random() * 10000, "Character" + count, generateRandomDate(), fileAnimalsService.getSecretCodeFromFile());
            }
            case 5: {
                List<String> listNames = namesListService.getLionNames();
                int r = (int) (Math.random() * listNames.size());
                return new Lion(listNames.get(r),"Breed" + count,
                        Math.random() * 10000, "Character" + count, generateRandomDate(), fileAnimalsService.getSecretCodeFromFile());
            }
            default:
                return null;
        }
    }

    private LocalDate generateRandomDate() {
        Random random = new Random();

        long startDate = LocalDate.of(1900, 1, 1).toEpochDay(); //Начальная дата
        long endDate = LocalDate.of(2022, 12, 31).toEpochDay(); //Конечная дата

        long randomDay = startDate + random.nextInt((int) (endDate - startDate));

        return LocalDate.ofEpochDay(randomDay);
    }
}
