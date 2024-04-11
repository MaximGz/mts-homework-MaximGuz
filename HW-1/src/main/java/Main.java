import animal.Animal;
import animal.pet.Cat;
import animal.pet.Cow;
import animal.pet.Dog;
import animal.predator.Lion;
import animal.predator.Shark;
import animal.predator.Wolf;
import animal.service.AnimalsRepositoryImpl;
import animal.service.CreateAnimalServiceImpl;
import animal.service.FileAnimalsService;
import animal.service.ResultReader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Главный класс с вызовом метода main
 */
public class Main {
    /**
     * Точка старта приложения
     *
     * @param args - входящие параметры
     */
    public static void main(String[] args) throws IOException {
        /*List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Animal1", "Breed1", 150.0d, "Character1", LocalDate.of(2001, 1, 1)));
        animals.add(new Cat("Animal2", "Breed2", 1000.12d, "Character2", LocalDate.of(2001, 3, 7)));
        animals.add(new Cow("Animal3", "Breed3", 500.3d, "Character3", LocalDate.of(2002, 5, 13)));
        animals.add(new Lion("Animal4", "Breed4", 1.8d, "Character4", LocalDate.of(2004, 1, 20)));
        animals.add(new Shark("Animal5", "Breed5", 600.0d, "Character5", LocalDate.of(2004, 9, 27)));
        animals.add(new Wolf("Animal6", "Breed6", 89.0d, "Character6", LocalDate.of(2006, 11, 30)));
        animals.add(new Dog("Animal7", "Breed7", 170.111d, "Character7", LocalDate.of(2007, 2, 3)));
        animals.add(new Cat("Animal8", "Breed8", 1034.19d, "Character8", LocalDate.of(2008, 4, 4)));
        animals.add(new Dog("Animal9", "Breed9", 470.111d, "Character9", LocalDate.of(2009, 6, 11)));

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        FileAnimalsService f = new FileAnimalsService();
        ResultReader rr = new ResultReader();
        AnimalsRepositoryImpl ari = new AnimalsRepositoryImpl();

        ari.findOlderAnimal(animals, 20);
        rr.readAnimalsFromJson();*/

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

//        System.out.println("\nFor cycle:");
//        Map<String, List<Animal>> cycleAnimals = createAnimalServiceImpl.createAnimals(10);
//
//        for (String name: cycleAnimals.keySet()) {
//            String key = name.toString();
//            String value = cycleAnimals.get(name).toString();
//            System.out.println(key + " " + value);
//        }
//
//        System.out.println("\nWhile cycle:");
//        Map<String, List<Animal>> whileAnimals = createAnimalServiceImpl.createAnimalsfromInterface();
//
//        for (String name: whileAnimals.keySet()) {
//            String key = name.toString();
//            String value = whileAnimals.get(name).toString();
//            System.out.println(key + " " + value);
//        }

    }

}
