package org.starter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.starter.Animal;
import org.starter.serializer.AnimalCustomSerializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FileAnimalsService {
    @Autowired
    PathsPropertyService pathsPropertyService;

    public void logAnimals(Animal a, int counter) {
        String s = pathsPropertyService.getLogPath();
        Path path = Paths.get(s);
        String data = counter + 1 + " " + a.getClass().getSimpleName() + " " + a.getName() + " " + a.getCost() + " " + a.getBirthDate() + "\n";

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            System.out.println("Информация о животном записана в файл.");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String getSecretCodeFromFile() {
        String s = pathsPropertyService.getSecretPath();
        Path path = Paths.get(s);

        List<String> stringsList = null;
        try {
            stringsList = Files.readAllLines(path);
        } catch (IOException e) {
            e.getMessage();
        }
        int r = new Random().nextInt(10);
        return stringsList.get(r);
    }

    public void writeAnimalsToJson(Map<Animal, Integer> animals) {
        Path path = Paths.get("HW-1", "src", "main", "resources", "results", "findOlderAnimals.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(Animal.class, new AnimalCustomSerializer());

        objectMapper.registerModule(module);

        try {
            objectMapper.writeValue(path.toFile(), animals.keySet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
