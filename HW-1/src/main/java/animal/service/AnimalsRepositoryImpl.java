package animal.service;

import animal.Animal;
import custexceptions.EmptyAnimalArrayException;
import custexceptions.NullAnimalArrayException;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс-имплементация интерфейса AnimalsRepository
 */
public class AnimalsRepositoryImpl implements AnimalsRepository {
    @Override
    public Map<String, LocalDate> indLeapYearNames(Animal[] animals) {
        if (animals == null) {
            throw new NullAnimalArrayException();
        }
        if (animals.length == 0) {
            throw new EmptyAnimalArrayException();
        }
        Map<String, LocalDate> map = new HashMap<>();
        for (Animal a : animals) {
            if (a.getBirthDate().isLeapYear()) {
                map.put(a.getClass().getSimpleName() + " " + a.getName(), a.getBirthDate());
            }
        }
        return map;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(Animal[] animals, int n) {
        if (animals == null) {
            throw new NullAnimalArrayException();
        }
        if (animals.length == 0) {
            throw new EmptyAnimalArrayException();
        }

        Map<Animal, Integer> map = new HashMap<>();
        int maxAge = 0;

        for (Animal a : animals) {
            int age = Period.between(a.getBirthDate(), LocalDate.now()).getYears();

            if (age > maxAge) {
                maxAge = age;
            }

            if (age > n) {
                map.put(a, age);
            }
        }
        //Если не нашлось животных возрастом больше n
        if (map.isEmpty()) {
            //Находим всех животных из массива с максимальный возрастом
            for (Animal a : animals) {
                int age = Period.between(a.getBirthDate(), LocalDate.now()).getYears();
                if (age == maxAge) {
                    map.put(a, age);
                }
            }
        }
        return map;
    }

    @Override
    public Map<String, Integer> findDuplicate(Animal[] animals) {
        if (animals == null) {
            throw new NullAnimalArrayException();
        }
        if (animals.length == 0) {
            throw new EmptyAnimalArrayException();
        }

        Map<String, Integer> map = new HashMap<>();
        for (Animal a : animals) {
            String type = a.getClass().getSimpleName();
            if (map.get(type) == null) {
                map.put(type, 1);
            } else {
                map.put(type, map.get(type) + 1);
            }
        }
        return map;
    }
}
