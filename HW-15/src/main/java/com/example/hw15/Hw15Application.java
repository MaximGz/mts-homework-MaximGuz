package com.example.hw15;

import com.example.hw15.entity.Animal;
import com.example.hw15.repository.AnimalRepository;
import com.example.hw15.repository.AnimalTypeRepository;
import com.example.hw15.service.AnimalService;
import com.example.hw15.service.AnimalTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Log4j2
@SpringBootApplication
public class Hw15Application {
    @Autowired
    AnimalTypeService animalTypeService;

    public static void main(String[] args) {
        SpringApplication.run(Hw15Application.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, AnimalTypeRepository animalTypeRepository, AnimalRepository animalRepository, AnimalService animalService) {
        return args -> {

//            Map<String, LocalDate> leapYearAnimals = animalService.findLeapYearNames();
//            for(String y : leapYearAnimals.keySet()) {
//                System.out.println(y + ": " + leapYearAnimals.get(y));
//            }
            List<Animal> olderThanAnimalList = animalRepository.findAllAnimalsOlderThan(5);
            olderThanAnimalList.forEach(System.out::println);

            List<Animal> an = animalRepository.getAllAnimals();
            an.forEach(System.out::println);

            Map<String, List<Animal>> ab = animalService.findDuplicate();
            for(String y : ab.keySet()) {
                System.out.println(ab.get(y));
            }

            Map<Animal, Integer> ab1 = animalService.findOlderAnimal(5);
            for(Animal y : ab1.keySet()) {
                System.out.println(y + ": " + ab1.get(y));
            }

//            animalRepository.deleteById(2L);
//
//            Animal a1 = new Animal("Doggy1", "Breed", 12.3, "Character",
//                    LocalDate.of(2023,8,31), animalTypeRepository.findByType("Dog"));
//            animalRepository.save(a1);
//            Animal a2 = new Animal("Doggy2", "Breed", 12.3, "Character",
//                    LocalDate.of(2023,8,31), animalTypeRepository.findByType("Dog"));
//            animalRepository.save(a2);
        };
    }

}
