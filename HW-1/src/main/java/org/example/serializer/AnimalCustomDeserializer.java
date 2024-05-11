package org.example.serializer;

import org.starter.Animal;
import org.starter.pet.Cat;
import org.starter.pet.Cow;
import org.starter.pet.Dog;
import org.starter.predator.Lion;
import org.starter.predator.Shark;
import org.starter.predator.Wolf;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;

public class AnimalCustomDeserializer extends JsonDeserializer<Animal> {

    @Override
    public Animal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException, IOException, IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String className = node.get("class").asText();
        String name = node.get("name").asText();
        String breed = node.get("breed").asText();
        String character = node.get("character").asText();
        LocalDate birthDate = LocalDate.parse(node.get("birthdate").asText());
        Double cost = node.get("cost").asDouble();
        String secretInformation = new String(Base64.getDecoder().decode(node.get("secretInformation").asText()));

        // Создаем объект Animal в зависимости от класса
        if ("Cat".equals(className)) {
            return new Cat(name, breed, cost, character, birthDate, secretInformation);
        } else if ("Dog".equals(className)) {
            return new Dog(breed, name, cost, character, birthDate, secretInformation);
        } else if ("Cow".equals(className)) {
            return new Cow(breed, name, cost, character, birthDate, secretInformation);
        } else if ("Shark".equals(className)) {
            return new Shark(breed, name, cost, character, birthDate, secretInformation);
        } else if ("Lion".equals(className)) {
            return new Lion(breed, name, cost, character, birthDate, secretInformation);
        } else if ("Wolf".equals(className)) {
            return new Wolf(breed, name, cost, character, birthDate, secretInformation);
        }
        return null;
    }
}
