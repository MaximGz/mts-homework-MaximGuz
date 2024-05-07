package org.starter.service;

import org.starter.AbstractAnimal;
import org.starter.Animal;

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
    public NamesListService randNames;

    public CreateAnimalServiceImpl(NamesListService randNames) {
        this.randNames = randNames;
    }

    public Map<String, List<Animal>> createAnimals(int n) {
        Map<String, List<Animal>> animalsMap = new HashMap<>();
        //FileAnimalsService f = new FileAnimalsService();

        for (int i = 0; i < n; i++) {
            int randomAnimal = (int) (Math.random() * 6);
            AbstractAnimal a = HelperService.switchAnimal(randomAnimal);
            String type = a.getClass().getSimpleName();

            switch (type) {
                case "Cat": {
                    List<String> listNames = randNames.getCatNames();
                    int r = (int) (Math.random() * listNames.size());
                    a.setName(listNames.get(r));
                    break;
                }
                case "Dog": {
                    List<String> listNames = randNames.getDogNames();
                    int r = (int) (Math.random() * listNames.size());
                    a.setName(listNames.get(r));
                    break;
                }
                case "Cow": {
                    List<String> listNames = randNames.getCowNames();
                    int r = (int) (Math.random() * listNames.size());
                    a.setName(listNames.get(r));
                    break;
                }
                case "Shark": {
                    List<String> listNames = randNames.getSharkNames();
                    int r = (int) (Math.random() * listNames.size());
                    a.setName(listNames.get(r));
                    break;
                }
                case "Lion": {
                    List<String> listNames = randNames.getLionNames();
                    int r = (int) (Math.random() * listNames.size());
                    a.setName(listNames.get(r));
                    break;
                }
                case "Wolf": {
                    List<String> listNames = randNames.getWolfNames();
                    int r = (int) (Math.random() * listNames.size());
                    a.setName(listNames.get(r));
                    break;
                }
                default: a.setName("Animal" + i);
            }
            a.setBreed("Breed" + i);
            a.setCharacter("Character" + i);
            a.setCost(Math.random() * 10000);
            a.setBirthDate(HelperService.generateRandomDate());

            animalsMap.computeIfAbsent(type, k -> new ArrayList<Animal>());

            animalsMap.get(type).add(a);
            //f.logAnimals(a, i);
        }

        return animalsMap;
    }

    public Map<String, List<Animal>> createAnimalsfromInterface() {
        return CreateAnimalService.super.createAnimals();
    }
}
