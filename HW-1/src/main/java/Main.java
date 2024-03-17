import animal.AbstractAnimal;
import animal.Animal;
import animal.pet.Cat;
import animal.pet.Cow;
import animal.pet.Dog;
import animal.predator.Lion;
import animal.predator.Shark;
import animal.predator.Wolf;
import animal.service.AnimalsRepositoryImpl;
import animal.service.CreateAnimalService;
import animal.service.CreateAnimalServiceImpl;
import animal.service.HelperService;
import custexceptions.InvalidAnimalBirthDateException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Главный класс с вызовом метода main
 */
public class Main {
    /**
     * Точка старта приложения
     * @param args - входящие параметры
     */
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        /*System.out.println("\nWhile cycle:");
        try {
            createAnimalServiceImpl.createAnimalsfromInterface();
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException("Работа метода завершилась ошибкой\n" + e);
        }
        System.out.println("\nFor cycle:");
        createAnimalServiceImpl.createAnimals(10);
        System.out.println("\nDo-While cycle:");
        createAnimalServiceImpl.createAnimals();*/

        System.out.println("\nFor cycle:");
        Map<String, List<Animal>> cycleAnimals = createAnimalServiceImpl.createAnimals(10);

        for (String name: cycleAnimals.keySet()) {
            String key = name.toString();
            String value = cycleAnimals.get(name).toString();
            System.out.println(key + " " + value);
        }

        System.out.println("\nWhile cycle:");
        Map<String, List<Animal>> whileAnimals = createAnimalServiceImpl.createAnimalsfromInterface();

        for (String name: whileAnimals.keySet()) {
            String key = name.toString();
            String value = whileAnimals.get(name).toString();
            System.out.println(key + " " + value);
        }
    }

}
