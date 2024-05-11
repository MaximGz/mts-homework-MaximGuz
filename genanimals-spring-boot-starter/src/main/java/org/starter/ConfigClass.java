package org.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.starter.factory.AnimalFactory;
import org.starter.service.CreateAnimalService;
import org.starter.service.CreateAnimalServiceImpl;
import org.starter.service.NamesListService;

@Configuration
public class ConfigClass {
    @Bean
    public NamesListService namesListService(){return new NamesListService(); }
    @Bean
    public AnimalFactory animalFactory() {
        return new AnimalFactory(namesListService());
    }
    @Bean
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl(animalFactory());
    }
}
