package animal.service;

import animal.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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

    public void logAnimals(Animal a, int counter) {
        Path path = Paths.get("HW-1", "src", "main", "resources", "animals", "logData.txt");
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
        Path path = Paths.get("HW-1", "src", "main", "resources", "secretStore", "secretInformation.txt");

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

//        for (Animal a : animals) {
//            AbstractAnimal an = (AbstractAnimal) a;
//            String secretInfo = an.getSecretInformation();
//            an.setSecretInformation(Base64.getEncoder().encodeToString(secretInfo.getBytes()));
//        }

        try {
            objectMapper.writeValue(path.toFile(), animals);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
