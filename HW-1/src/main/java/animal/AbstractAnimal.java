package animal;

import animal.service.FileAnimalsService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Родительский класс всех животных
 */
public abstract class AbstractAnimal implements Animal {
    FileAnimalsService f = new FileAnimalsService();
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
        this.secretInformation = f.getSecretCodeFromFile();
    }

    public AbstractAnimal(String name, String breed, Double cost, String character, LocalDate birthDate, String secretInformation) {
        this.name = name;
        this.breed = breed;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
        this.secretInformation = secretInformation;
    }


    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSecretInformation(String secretInformation) {
        this.secretInformation = secretInformation;
    }

    /**
     * @return - получаем значение породы
     */
    @Override
    public String getBreed() {
        return breed;
    }

    /**
     * @return - получаем значение имени
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return - получаем значение стоимости
     */
    @Override
    public Double getCost() {
        return cost;
    }

    /**
     * @return - получаем значение характера
     */
    @Override
    public String getCharacter() {
        return character;
    }

    /**
     * @return - получаем дату рождения
     */
    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String getSecretInformation() {
        return secretInformation;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getName() + ", " + this.getBreed() + ", " +
                this.getCharacter() + ", " + String.format("%.2f", this.getCost()) + ", " +
                DateTimeFormatter.ofPattern("dd-MM-yyyy").format(birthDate) + ", " + this.getSecretInformation();
    }
}
