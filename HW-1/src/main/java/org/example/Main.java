package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.starter.Animal;
import org.starter.serializer.AnimalCustomDeserializer;
import org.starter.serializer.AnimalCustomSerializer;
import org.starter.service.CreateAnimalService;
import org.starter.service.FileAnimalsService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Главный класс с вызовом метода main
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            AnimalsRepository c = ctx.getBean(AnimalsRepository.class);
            Map<String, List<Animal>> d = c.getAnimalStorage();
            for(String y : d.keySet()) {
                System.out.println(d.get(y));
            }


//            FileAnimalsService f = ctx.getBean(FileAnimalsService.class);
//            System.out.println(f.secretPath);
//            String s1 = "HW-1/src/main/resources/secretStore/secretInformation.txt";
//            Path p = Paths.get(s1);
//            System.out.println(p.toFile());
//            System.out.println(p.toFile().exists());
//            List<String> stringsList = Files.readAllLines(p);
//            for (String s : stringsList) {
//                System.out.println(s);
//            }
        };
    }

    private final CreateAnimalService createAnimalService;
    private final FileAnimalsService fileAnimalsService;
    private final AnimalCustomDeserializer animalCustomDeserializer;
    private final AnimalCustomSerializer animalCustomSerializer;

    public Main(CreateAnimalService createAnimalService, FileAnimalsService fileAnimalsService,
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
