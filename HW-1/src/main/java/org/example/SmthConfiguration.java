package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.starter.serializer.AnimalCustomDeserializer;
import org.starter.serializer.AnimalCustomSerializer;
import org.starter.service.CreateAnimalService;
import org.starter.service.FileAnimalsService;

@Configuration
public class SmthConfiguration {
    private final CreateAnimalService createAnimalService;
    private final FileAnimalsService fileAnimalsService;
    private final AnimalCustomDeserializer animalCustomDeserializer;
    private final AnimalCustomSerializer animalCustomSerializer;

    public SmthConfiguration(CreateAnimalService createAnimalService, FileAnimalsService fileAnimalsService,
                AnimalCustomDeserializer animalCustomDeserializer, AnimalCustomSerializer animalCustomSerializer) {
        this.createAnimalService = createAnimalService;
        this.fileAnimalsService = fileAnimalsService;
        this.animalCustomDeserializer = animalCustomDeserializer;
        this.animalCustomSerializer = animalCustomSerializer;
    }

    @Bean
    public AnimalsRepository animalsRepository() {
        return new AnimalsRepositoryImpl(fileAnimalsService, createAnimalService);
    }

    @Bean
    public SearchService searchService() {
        return new SearchServiceImpl();
    }


    @Bean
    public ResultReader resultReader() {
        return new ResultReader(animalCustomDeserializer);
    }
}
