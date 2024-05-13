package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.starter.Animal;

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
}
