package animal.service;

import animal.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ResultReader {

    public void readAnimalsFromJson() {
        Path path = Paths.get("HW-1", "src", "main", "resources", "results", "findOlderAnimals.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<Animal, Integer> animals = objectMapper.readValue(path.toFile(), Map.class);
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
