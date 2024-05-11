package org.starter;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.starter.factory.AnimalFactory;
import org.starter.serializer.AnimalCustomDeserializer;
import org.starter.serializer.AnimalCustomSerializer;
import org.starter.service.*;

@SpringBootConfiguration
public class ConfigClass {
    @Bean
    public FileAnimalsService fileAnimalsService() {
        return new FileAnimalsService();
    }

    @Bean
    public NamesListService namesListService() {
        return new NamesListService();
    }

    @Bean
    public AnimalFactory animalFactory() {
        return new AnimalFactory(namesListService());
    }

    @Bean
    public AnimalCustomSerializer animalCustomSerializer() {
        return new AnimalCustomSerializer();
    }

    @Bean
    public AnimalCustomDeserializer animalCustomDeserializer() {
        return new AnimalCustomDeserializer();
    }

    @Bean
    public PathsPropertyService pathsPropertyService() {
        return new PathsPropertyService();
    }

    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl(animalFactory(), fileAnimalsService());
    }
}
