package org.starter;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Родительский класс всех животных
 */
@Data
public abstract class AbstractAnimal implements Animal {
    //FileAnimalsService f = new FileAnimalsService();
    /**
     * Порода
     */
    protected String breed;
    /**
     * Имя
     */
    protected String name;
    /**
     * Стоимость
     */
    protected Double cost;
    /**
     * Характер
     */
    protected String character;
    /**
     * Дата рождения животного
     */
    protected LocalDate birthDate;
    protected String secretInformation;

    public AbstractAnimal() {

    }

    public AbstractAnimal(String name, String breed, Double cost, String character, LocalDate birthDate) {
        this.name = name;
        this.breed = breed;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
        //this.secretInformation = f.getSecretCodeFromFile();
    }

    public AbstractAnimal(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        this.name = name;
        this.breed = breed;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
        this.secretInformation = secretInformation;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getName() + ", " + this.getBreed() + ", " +
                this.getCharacter() + ", " + String.format("%.2f", this.getCost()) + ", " +
                DateTimeFormatter.ofPattern("dd-MM-yyyy").format(birthDate) + ", " + this.getSecretInformation();
    }
}
