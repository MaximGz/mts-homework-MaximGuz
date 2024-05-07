package org.starter.service;

import org.starter.AbstractAnimal;
import org.starter.Animal;
import org.starter.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс-сервис, наследуемый от CreateAnimalService
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {
    //    /**
//     * Перегруженный метод интерфейса для создания N животных, используя цикл for
//     *
//     * @param n - количество животных
//     * @see CreateAnimalService
//     */
//    public void createAnimals(int n) {
//        for (int i = 0; i < n; i++) {
//            int randomAnimal = (int) (Math.random() * 6);
//            AbstractAnimal animal = HelperService.switchAnimal(randomAnimal);
//
//            animal.setName("Animals.Animal" + i);
//            animal.setBreed("Breed" + i);
//            animal.setCharacter("Character" + i);
//            animal.setCost(Math.random() * 10000);
//            animal.setBirthDate(HelperService.generateRandomDate());
//
//            System.out.println(animal);
//        }
//    }
//
//    /**
//     * Переопределенный метод интерфейса
//     *
//     * @see CreateAnimalService
//     * для создания 10 животных, используя цикл do-while
//     */
//    @Override
//    public void createAnimals() {
//        int count = 0;
//
//        do {
//            int randomAnimal = (int) (Math.random() * 6);
//            AbstractAnimal animal = HelperService.switchAnimal(randomAnimal);
//
//            animal.setName("Animals.Animal" + count);
//            animal.setBreed("Breed" + count);
//            animal.setCharacter("Character" + count);
//            animal.setCost(Math.random() * 10000);
//            animal.setBirthDate(HelperService.generateRandomDate());
//
//            System.out.println(animal);
//            count++;
//        } while (count < 10);
//    }
//
//    public void createAnimalsfromInterface() throws InvalidAnimalBirthDateException {
//        CreateAnimalService.super.createAnimals();
//    }
    public AnimalFactory animalFactory;

    public CreateAnimalServiceImpl(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    public Map<String, List<Animal>> createAnimals(int n) {
        Map<String, List<Animal>> animalsMap = new HashMap<>();
        //FileAnimalsService f = new FileAnimalsService();

        for (int i = 0; i < n; i++) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal a = animalFactory.switchAnimal(randomAnimal, i);
            String type = a.getClass().getSimpleName();

            animalsMap.computeIfAbsent(type, k -> new ArrayList<Animal>());
            animalsMap.get(type).add(a);
            //f.logAnimals(a, i);
        }

        return animalsMap;
    }

//    public Map<String, List<Animal>> createAnimalsfromInterface() {
//        return CreateAnimalService.super.createAnimals();
//    }
}