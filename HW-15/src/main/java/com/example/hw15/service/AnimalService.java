package com.example.hw15.service;

import com.example.hw15.custexceptions.EmptyAnimalArrayException;
import com.example.hw15.entity.Animal;
import com.example.hw15.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public Animal addAnimal(Animal a) {
        return animalRepository.save(a);
    }

    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }

    public Map<String, List<Animal>> findDuplicate() {
        List<Animal> animals = animalRepository.getAllAnimals();

        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }

        Map<String, List<Animal>> map = animals.stream()
                .collect(Collectors.groupingBy(a -> a.getType().getType(), Collectors.mapping(a -> a, toList())));

        return map;
    }

    public Map<Animal, Integer> findOlderAnimal(int n) {
        List<Animal> animals = animalRepository.findAllAnimalsOlderThan(n);
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

        return result;
    }

    public Map<String, LocalDate> findLeapYearNames() {
        List<Animal> animals = animalRepository.findLeapYearNames();
        if (animals.isEmpty()) {
            throw new EmptyAnimalArrayException("На вход передан пустой список");
        }

        Map<String, LocalDate> map = animals.stream()
                .filter(a -> a.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(a -> a.getType().getType() + " " + a.getName(), Animal::getBirthDate));

        return map;
    }
}
