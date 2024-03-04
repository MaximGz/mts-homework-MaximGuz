package AnimalGeneral;

/**
 * Интерфейс, описывающий поведение животных
 */
public interface Animal {
    /**
     * Метод для получения породы
     */
    String getBreed();
    /**
     * Метод для получения имени
     */
    String getName();
    /**
     * Метод для получения стоимости
     */
    Double getCost();
    /**
     * Метод для получения характера
     */
    String getCharacter();
}
