package animal.service;

import animal.Animal;
import animal.serializer.AnimalCustomDeserializer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ResultReader {

    public void readAnimalsFromJson() {
        Path path = Paths.get("HW-1", "src", "main", "resources", "results", "findOlderAnimals.json");
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Animal.class, new AnimalCustomDeserializer());

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(module);
        try {
            List<Animal> a = objectMapper.readValue(path.toFile(), new TypeReference<List<Animal>>() {});
            for (Animal i : a) {
                System.out.println(i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
