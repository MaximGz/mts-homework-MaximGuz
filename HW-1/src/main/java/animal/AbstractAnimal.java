package animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Родительский класс всех животных
 */
public abstract class AbstractAnimal implements Animal {
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
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getName() + ", " + this.getBreed() + ", " +
                this.getCharacter() + ", " + String.format("%.2f", this.getCost()) + ", " + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(birthDate);
    }
}
