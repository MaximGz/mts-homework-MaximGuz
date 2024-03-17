package animal.service;

import animal.AbstractAnimal;
import animal.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CreateAnimalService {
//    /**
//     * Дефолт метод по созданию 10 животных
//     */
//    default void createAnimals() throws InvalidAnimalBirthDateException {
//        int count = 0;
//        SearchServiceImpl ssi = new SearchServiceImpl();
//        while (count < 10) {
//            int randomAnimal = (int) (Math.random() * 6);
//            AbstractAnimal animal = HelperService.switchAnimal(randomAnimal);
//
//            //реализовал логику через сеттеры, т.к. раскидал все классы по пакетам и теперь из этого класса
//            //нет доступа к protected переменным
//            animal.setName("Animals.Animal" + count);
//            animal.setBreed("Breed" + count);
//            animal.setCost(Math.random() * 10000);
//            animal.setCharacter("Character" + count);
//            animal.setBirthDate(HelperService.generateRandomDate());
//
//            System.out.println(animal);
//
//            ssi.checkLeapYearAnimal(animal);
//
//            count++;
//        }
//    }

    default Map<String, List<Animal>> createAnimals() {
        Map<String, List<Animal>> animalsMap = new HashMap<>();
        int count = 0;

        while (count < 10) {
            int randomAnimal = (int) (Math.random() * 6);; // Генерируем случайное число для определения типа животного
            AbstractAnimal a = HelperService.switchAnimal(randomAnimal);
            String type = a.getClass().getSimpleName();

            a.setName("Animals.Animal" + count);
            a.setBreed("Breed" + count);
            a.setCost(Math.random() * 10000);
            a.setCharacter("Character" + count);
            a.setBirthDate(HelperService.generateRandomDate());

            if (animalsMap.get(type) == null) {
                animalsMap.put(type, new ArrayList<Animal>());
            }

            animalsMap.get(type).add(a);

            count++;
        }

        return animalsMap;
    }


}
