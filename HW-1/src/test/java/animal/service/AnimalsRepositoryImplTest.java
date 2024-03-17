package animal.service;

import animal.Animal;
import animal.pet.Cat;
import animal.pet.Cow;
import animal.pet.Dog;
import animal.predator.Lion;
import animal.predator.Shark;
import animal.predator.Wolf;
import custexceptions.EmptyAnimalArrayException;
import custexceptions.NullAnimalArrayException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsRepositoryImplTest {
    AnimalsRepositoryImpl ari = new AnimalsRepositoryImpl();
    private Animal[] animals() {
        Animal[] animals = {
                new Dog("Animal1", "Breed1", 150.0d, "Character1", LocalDate.of(2001, 1, 1)),
                new Cat("Animal2", "Breed2", 1000.12d, "Character2", LocalDate.of(2001, 3, 7)),
                new Cow("Animal3", "Breed3", 20.3d, "Character3", LocalDate.of(2002, 5, 13)),
                new Lion("Animal4", "Breed4", 1.8d, "Character4", LocalDate.of(2004, 1, 20)),
                new Shark("Animal5", "Breed5", 167.0d, "Character5", LocalDate.of(2004, 9, 27)),
                new Wolf("Animal6", "Breed6", 89.0d, "Character6", LocalDate.of(2006, 11, 30)),
                new Dog("Animal7", "Breed7", 870.111d, "Character7", LocalDate.of(2007, 2, 3)),
                new Cat("Animal8", "Breed8", 1034.19d, "Character8", LocalDate.of(2008, 4, 4)),
                new Dog("Animal9", "Breed9", 870.111d, "Character9", LocalDate.of(2009, 6, 11)),
        };

        return animals;
    }

    @DisplayName("Проверка метода findLeapYearNames на корректность")
    @Test
    void findLeapYearNamesTest() {
        Map<String, LocalDate> map = ari.findLeapYearNames(animals());

        assertEquals(3, map.size());
        assertEquals(LocalDate.of(2004, 1, 20), map.get("Lion Animal4"));
        assertEquals(LocalDate.of(2004, 9, 27), map.get("Shark Animal5"));
        assertEquals(LocalDate.of(2008, 4, 4), map.get("Cat Animal8"));
    }

    @DisplayName("Проверка метода findLeapYearNames на исключение NullAnimalArrayException, EmptyAnimalArrayException")
    @Test
    void findLeapYearNamesExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findLeapYearNames(new Animal[]{});
                });
        assertThrows(NullAnimalArrayException.class,
                () -> {
                    ari.findLeapYearNames(null);
                });
    }

    @DisplayName("Проверка метода findDuplicate на корректность")
    @Test
    void findDuplicate() {
        Map<String, Integer> map = ari.findDuplicate(animals());
        assertEquals(6, map.size());
        assertEquals(3, map.get("Dog"));
        assertEquals(2, map.get("Cat"));
        assertEquals(1, map.get("Cow"));
        assertEquals(1, map.get("Lion"));
        assertEquals(1, map.get("Shark"));
        assertEquals(1, map.get("Wolf"));
    }

    @DisplayName("Проверка метода findDuplicate на исключение NullAnimalArrayException, EmptyAnimalArrayException")
    @Test
    void findDuplicateExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findLeapYearNames(new Animal[]{});
                });
        assertThrows(NullAnimalArrayException.class,
                () -> {
                    ari.findLeapYearNames(null);
                });
    }

    @DisplayName("\"Проверка метода findOlderAnimal в случае, если найдены животные старше N")
    @Test
    void findOlderThan20Animals() {
        Animal[] animalArray = animals();

        Map<Animal, Integer> map = ari.findOlderAnimal(animalArray, 20);

        assertEquals(3, map.size());
        assertTrue(map.containsKey(animalArray[0]));
        assertEquals(23, map.get(animalArray[0]));
        assertTrue(map.containsKey(animalArray[1]));
        assertEquals(23, map.get(animalArray[1]));
        assertTrue(map.containsKey(animalArray[2]));
        assertEquals(21, map.get(animalArray[2]));

        assertFalse(map.containsKey(animalArray[3]));
        assertFalse(map.containsKey(animalArray[4]));
        assertFalse(map.containsKey(animalArray[5]));
        assertFalse(map.containsKey(animalArray[6]));
        assertFalse(map.containsKey(animalArray[7]));
        assertFalse(map.containsKey(animalArray[8]));

    }

    @DisplayName("Проверка метода findOlderAnimal в случае, если НЕ найдены животные старше N")
    @Test
    void findOlderThan100Animals() {
        Animal[] animalArray = animals();

        Map<Animal, Integer> map = ari.findOlderAnimal(animalArray, 100);
        assertEquals(2, map.size());
        assertTrue(map.containsKey(animalArray[0]));
        assertEquals(23, map.get(animalArray[0]));
        assertTrue(map.containsKey(animalArray[1]));
        assertEquals(23, map.get(animalArray[1]));

        assertFalse(map.containsKey(animalArray[2]));
        assertFalse(map.containsKey(animalArray[3]));
        assertFalse(map.containsKey(animalArray[4]));
        assertFalse(map.containsKey(animalArray[5]));
        assertFalse(map.containsKey(animalArray[6]));
        assertFalse(map.containsKey(animalArray[7]));
        assertFalse(map.containsKey(animalArray[8]));
    }

    @DisplayName("Проверка метода findOlderThan на исключение NullAnimalArrayException, EmptyAnimalArrayException")
    @Test
    void findOlderThanExceptionTest() {
        assertThrows(EmptyAnimalArrayException.class,
                () -> {
                    ari.findOlderAnimal(new Animal[]{}, 0);
                });
        assertThrows(NullAnimalArrayException.class,
                () -> {
                    ari.findOlderAnimal(null, 0);
                });
    }
}