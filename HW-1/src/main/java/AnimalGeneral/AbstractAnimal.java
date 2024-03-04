package AnimalGeneral;

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

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getName() + ", " + this.getBreed() + ", " + this.getCharacter() + ", " + String.format("%.2f", this.getCost());
    }
}
