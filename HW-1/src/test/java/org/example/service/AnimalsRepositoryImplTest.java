package org.example.service;

import org.example.AnimalsRepositoryImpl;
import org.example.custexceptions.EmptyAnimalArrayException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.starter.Animal;
import org.starter.factory.AnimalFactory;
import org.starter.pet.Cat;
import org.starter.pet.Cow;
import org.starter.pet.Dog;
import org.starter.predator.Lion;
import org.starter.predator.Shark;
import org.starter.predator.Wolf;
import org.starter.service.CreateAnimalService;
import org.starter.service.CreateAnimalServiceImpl;
import org.starter.service.FileAnimalsService;
import org.starter.service.NamesListService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsRepositoryImplTest {
    FileAnimalsService fileAnimalsService = new FileAnimalsService();
    NamesListService namesListService = new NamesListService();
    AnimalFactory animalFactory = new AnimalFactory(namesListService);
    CreateAnimalService createAnimalService = new CreateAnimalServiceImpl(animalFactory, fileAnimalsService);
    AnimalsRepositoryImpl ari = new AnimalsRepositoryImpl(fileAnimalsService, createAnimalService);

    private Animal[] animals() {
        Animal[] animalsArray = {
                new Dog("Animal1", "Breed1", 150.0d, "Character1", LocalDate.of(2001, 1, 1)),
                new Cat("Animal2", "Breed2", 1000.12d, "Character2", LocalDate.of(2001, 3, 7)),
                new Cow("Animal3", "Breed3", 500.3d, "Character3", LocalDate.of(2002, 5, 13)),
                new Lion("Animal4", "Breed4", 1.8d, "Character4", LocalDate.of(2004, 1, 20)),
                new Shark("Animal5", "Breed5", 600.0d, "Character5", LocalDate.of(2004, 9, 27)),
                new Wolf("Animal6", "Breed6", 89.0d, "Character6", LocalDate.of(2006, 11, 30)),
                new Dog("Animal7", "Breed7", 170.111d, "Character7", LocalDate.of(2007, 2, 3)),
                new Cat("Animal8", "Breed8", 1034.19d, "Character8", LocalDate.of(2008, 4, 4)),
                new Dog("Animal9", "Breed9", 470.111d, "Character9", LocalDate.of(2009, 6, 11)),
        };

        return animalsArray;
    }

    private List<Animal> animalsList() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Animal1", "Breed1", 150.0d, "Character1", LocalDate.of(2001, 1, 1)));
        animals.add(new Cat("Animal2", "Breed2", 1000.12d, "Character2", LocalDate.of(2001, 3, 7)));
        animals.add(new Cow("Animal3", "Breed3", 500.3d, "Character3", LocalDate.of(2002, 5, 13)));
        animals.add(new Lion("Animal4", "Breed4", 1.8d, "Character4", LocalDate.of(2004, 1, 20)));
        animals.add(new Shark("Animal5", "Breed5", 600.0d, "Character5", LocalDate.of(2004, 9, 27)));
        animals.add(new Wolf("Animal6", "Breed6", 89.0d, "Character6", LocalDate.of(2006, 11, 30)));
        animals.add(new Dog("Animal7", "Breed7", 170.111d, "Character7", LocalDate.of(2007, 2, 3)));
        animals.add(new Cat("Animal8", "Breed8", 1034.19d, "Character8", LocalDate.of(2008, 4, 4)));
        animals.add(new Dog("Animal9", "Breed9", 470.111d, "Character9", LocalDate.of(2009, 6, 11)));

        return animals;
    }

    @DisplayName("Проверка метода findLeapYearNames на корректность")
    @Test
    void findLeapYearNamesTest() {
        Map<String, LocalDate> map = ari.findLeapYearNames(animalsList());

        assertEquals(3, map.size());
        assertEquals(LocalDate.of(2004, 1, 20), map.get("Lion Animal4"));
        assertEquals(LocalDate.of(2004, 9, 27), map.get("Shark Animal5"));
        assertEquals(LocalDate.of(2008, 4, 4), map.get("Cat Animal8"));
    }

    @DisplayName("Проверка метода findLeapYearNames на исключение EmptyAnimalArrayException")
    @Test
    void findLeapYearNamesExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findLeapYearNames(new ArrayList<Animal>());
                });
    }

    @DisplayName("Проверка метода findDuplicate на корректность")
    @Test
    void findDuplicate() {
        Map<String, List<Animal>> map = ari.findDuplicate(animalsList());
        assertEquals(6, map.size());
        assertEquals(3, map.get("Dog").size());
        assertEquals(2, map.get("Cat").size());
        assertEquals(1, map.get("Cow").size());
        assertEquals(1, map.get("Lion").size());
        assertEquals(1, map.get("Shark").size());
        assertEquals(1, map.get("Wolf").size());
    }

    @DisplayName("Проверка метода findDuplicate на исключение EmptyAnimalArrayException")
    @Test
    void findDuplicateExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findLeapYearNames(new ArrayList<>());
                });
    }

    @DisplayName("Проверка метода findOlderAnimal в случае, если найдены животные старше N")
    @Test
    void findOlderThan20Animals() {
        List<Animal> animalList = animalsList();


        Map<Animal, Integer> map = ari.findOlderAnimal(animalList, 20);

        for (Map.Entry<Animal, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        assertEquals(3, map.size());
        assertTrue(map.containsKey(animalList.get(0)));
        assertEquals(23, map.get(animalList.get(0)));
        assertTrue(map.containsKey(animalList.get(1)));
        assertEquals(23, map.get(animalList.get(1)));
        assertTrue(map.containsKey(animalList.get(2)));
        assertEquals(21, map.get(animalList.get(2)));

        assertFalse(map.containsKey(animalList.get(3)));
        assertFalse(map.containsKey(animalList.get(4)));
        assertFalse(map.containsKey(animalList.get(5)));
        assertFalse(map.containsKey(animalList.get(6)));
        assertFalse(map.containsKey(animalList.get(7)));
        assertFalse(map.containsKey(animalList.get(8)));

    }

    @DisplayName("Проверка метода findOlderAnimal в случае, если НЕ найдены животные старше N")
    @Test
    void findOlderThan100Animals() {
        List<Animal> animalList = animalsList();

        Map<Animal, Integer> map = ari.findOlderAnimal(animalList, 100);
        assertEquals(2, map.size());
        assertTrue(map.containsKey(animalList.get(0)));
        assertEquals(23, map.get(animalList.get(0)));
        assertTrue(map.containsKey(animalList.get(1)));
        assertEquals(23, map.get(animalList.get(1)));

        assertFalse(map.containsKey(animalList.get(2)));
        assertFalse(map.containsKey(animalList.get(3)));
        assertFalse(map.containsKey(animalList.get(4)));
        assertFalse(map.containsKey(animalList.get(5)));
        assertFalse(map.containsKey(animalList.get(6)));
        assertFalse(map.containsKey(animalList.get(7)));
        assertFalse(map.containsKey(animalList.get(8)));
    }

    @DisplayName("Проверка метода findOlderThan на исключение EmptyAnimalArrayException")
    @Test
    void findOlderThanExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findOlderAnimal(new ArrayList<Animal>(), 0);
                });
    }

    @DisplayName("Проверка метода findAverageAge на корректность")
    @Test
    void findAverageAge() {
        BigDecimal avg = ari.findAverageAge(Arrays.asList(animals()));
        assertEquals(avg.doubleValue(), 18.78);
    }

    @DisplayName("Проверка метода findAverageAge на исключение EmptyAnimalArrayException")
    @Test
    void findAverageAgeExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    BigDecimal averageAge = ari.findAverageAge(new ArrayList<>());
                });
    }

    @DisplayName("Проверка метода findOldAndExpensive на корректность")
    @Test
    void findOldAndExpensive() {
        List<Animal> animalList = animalsList();
        List<Animal> result = ari.findOldAndExpensive(animalList);

        assertEquals(3, result.size());
        assertEquals(result.get(0), animalList.get(1));
        assertEquals(result.get(1), animalList.get(2));
        assertEquals(result.get(2), animalList.get(4));
    }

    @DisplayName("Проверка метода findOldAndExpensive на исключение EmptyAnimalArrayException")
    @Test
    void findOldAndExpensiveExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findOldAndExpensive(new ArrayList<>());
                });
    }

    @DisplayName("Проверка метода findMinConstAnimals на корректность")
    @Test
    void findMinConstAnimals() {
        List<Animal> animalsList = animalsList();
        List<Animal> result = ari.findMinConstAnimals(animalsList);

        assertEquals(3, result.size());
        assertEquals(result.get(0), animalsList.get(5));
        assertEquals(result.get(1), animalsList.get(3));
        assertEquals(result.get(2), animalsList.get(0));
    }

    @DisplayName("Проверка метода findMinConstAnimals на исключение EmptyAnimalArrayException")
    @Test
    void findMinConstAnimalsExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findMinConstAnimals(new ArrayList<>());
                });
    }
}