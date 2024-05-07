package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.starter.Animal;
import org.starter.service.CreateAnimalService;

import java.util.List;
import java.util.Map;

/**
 * Главный класс с вызовом метода main
 */
@SpringBootApplication
public class Main {
    /**
     * Точка старта приложения
     *
     * @param args - входящие параметры
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            CreateAnimalService c = ctx.getBean(CreateAnimalService.class);
            Map<String, List<Animal>> d = c.createAnimals(10);
            for(String y : d.keySet()) {
                System.out.println(d.get(y));
            }
        };
    }
}
