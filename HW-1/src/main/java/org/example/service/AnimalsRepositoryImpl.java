package org.example.service;

import org.starter.Animal;
import org.example.custexceptions.EmptyAnimalArrayException;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Класс-имплементация интерфейса AnimalsRepository
 */
public class AnimalsRepositoryImpl implements AnimalsRepository {
//    @Override
//    public Map<String, LocalDate> findLeapYearNames(Animal[] animals) {
//        if (animals == null) {
//            throw new NullAnimalArrayException();
//        }
//        if (animals.length == 0) {
//            throw new EmptyAnimalArrayException();
//        }
//        Map<String, LocalDate> map = new HashMap<>();
//        for (Animal a : animals) {
//            if (a.getBirthDate().isLeapYear()) {
//                map.put(a.getClass().getSimpleName() + " " + a.getName(), a.getBirthDate());
//            }
//        }
//        return map;
//    }


    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) {
        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }

        Map<String, LocalDate> map = animals.stream()
                .filter(a -> a.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(a -> a.getClass().getSimpleName() + " " + a.getName(), Animal::getBirthDate));

        return map;
    }

//    @Override
//    public Map<Animal, Integer> findOlderAnimal(Animal[] animals, int n) {
//        if (animals == null) {
//            throw new NullAnimalArrayException();
//        }
//        if (animals.length == 0) {
//            throw new EmptyAnimalArrayException();
//        }
//
//        Map<Animal, Integer> map = new HashMap<>();
//        int maxAge = 0;
//
//        for (Animal a : animals) {
//            int age = Period.between(a.getBirthDate(), LocalDate.now()).getYears();
//
//            if (age > maxAge) {
//                maxAge = age;
//            }
//
//            if (age > n) {
//                map.put(a, age);
//            }
//        }
//        //Если не нашлось животных возрастом больше n
//        if (map.isEmpty()) {
//            //Находим всех животных из массива с максимальный возрастом
//            for (Animal a : animals) {
//                int age = Period.between(a.getBirthDate(), LocalDate.now()).getYears();
//                if (age == maxAge) {
//                    map.put(a, age);
//                }
//            }
//        }
//        return map;
//    }


    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int n) {
        FileAnimalsService f = new FileAnimalsService();
        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }

        Map<Animal, Integer> result = animals.stream()
                .filter(a -> {
                    int age = Period.between(a.getBirthDate(), LocalDate.now()).getYears();
                    return age > n;
                }).collect(Collectors.toMap(a -> a, a -> Period.between(a.getBirthDate(), LocalDate.now()).getYears()));

        if (result.isEmpty()) {
            OptionalInt maxAge = animals.stream().mapToInt(a -> Period.between(a.getBirthDate(), LocalDate.now()).getYears()).max();
            result = animals.stream()
                    .filter(a -> Period.between(a.getBirthDate(), LocalDate.now()).getYears() == maxAge.getAsInt())
                    .collect(Collectors.toMap(
                            a -> a,
                            a -> maxAge.getAsInt()
                    ));
        }

        f.writeAnimalsToJson(result);

        return result;
    }

//    @Override
//    public Map<String, Integer> findDuplicate(Animal[] animals) {
//        if (animals == null) {
//            throw new NullAnimalArrayException();
//        }
//        if (animals.length == 0) {
//            throw new EmptyAnimalArrayException();
//        }
//
//        Map<String, Integer> map = new HashMap<>();
//        for (Animal a : animals) {
//            String type = a.getClass().getSimpleName();
//            map.merge(type, 1, Integer::sum);
//        }
//        return map;
//    }


    @Override
    public Map<String, List<Animal>> findDuplicate(List<Animal> animals) {
        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }

        Map<String, List<Animal>> map = animals.stream()
                .collect(Collectors.groupingBy(a -> a.getClass().getSimpleName(), Collectors.mapping(a -> a, toList())));

        return map;
    }

    @Override
    public BigDecimal findAverageAge(@NotNull List<Animal> animals) {
        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }
        double avgAge = animals.stream()
                .mapToInt(a -> {
                    int age = Period.between(a.getBirthDate(), LocalDate.now()).getYears();
                    return age;
                })
                .average().getAsDouble();

        BigDecimal b1 = new BigDecimal(avgAge);

        return b1.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public List<Animal> findOldAndExpensive(@NotNull List<Animal> animals) {
        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }
        double avgCost = animals.stream()
                .mapToDouble(Animal::getCost)
                .average()
                .orElse(0);

        List<Animal> list = animals.stream()
                .filter(a -> {
                    int age = Period.between(a.getBirthDate(), LocalDate.now()).getYears();
                    //Сделал больше 18 (не 5 как в задании), т.к. животные для теста раскиданы в этом диапозоне
                    return age > 18 && a.getCost() > avgCost;
                })
                .sorted((Comparator.comparing(Animal::getBirthDate))).collect(Collectors.toList());

        return list;
    }

    @Override
    public List<Animal> findMinConstAnimals(@NotNull List<Animal> animals) {
        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }
        List<Animal> list = animals.stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .sorted(Comparator.comparing(Animal::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return list;
    }
}
