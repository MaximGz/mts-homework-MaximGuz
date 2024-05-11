package org.example.serializer;

import org.starter.Animal;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;

public class AnimalCustomSerializer extends StdSerializer<Animal> {

    public AnimalCustomSerializer() {
        super(Animal.class);
    }

    @Override
    public void serialize(Animal animal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("class", animal.getClass().getSimpleName());
        jsonGenerator.writeStringField("name", animal.getName());
        jsonGenerator.writeNumberField("age", Period.between(animal.getBirthDate(), LocalDate.now()).getYears());
        jsonGenerator.writeStringField("birthdate", animal.getBirthDate().toString());
        jsonGenerator.writeStringField("character", animal.getCharacter());
        jsonGenerator.writeStringField("breed", animal.getBreed());
        jsonGenerator.writeNumberField("cost", animal.getCost());
        jsonGenerator.writeStringField("secretInformation", Base64.getEncoder().encodeToString(animal.getSecretInformation().getBytes()));
        jsonGenerator.writeEndObject();
    }
}