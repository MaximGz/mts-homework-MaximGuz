package com.example.hw15.resolver;

import com.example.hw15.entity.Animal;
import com.example.hw15.repository.AnimalRepository;
import com.example.hw15.service.AnimalService;
import jakarta.annotation.Nullable;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Component;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
public class AnimalQuery {
    private AnimalRepository animalRepository;
    private AnimalService animalService;

    public AnimalQuery(AnimalRepository animalRepository, AnimalService animalService) {
        this.animalRepository = animalRepository;
        this.animalService = animalService;
    }

    @QueryMapping
    public List<Animal> animals(@Argument Integer count) {
        log.info("TEST");
        return this.animalService.getAllAnimals(count);
    }
    @QueryMapping
    public Optional<Animal> animal(@Argument Long id) {
        return this.animalRepository.findById(id);
    }
}
