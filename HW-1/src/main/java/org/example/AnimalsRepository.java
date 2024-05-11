package org.example;

import org.starter.Animal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Интерфейс AnimalRepository
 */
public interface AnimalsRepository {

    public Map<String, List<Animal>> getAnimalStorage();

    /**
     * найти всех животных, которые родились в високосный год
     *
     * @param animals - массив животных
     * @return - мапа Map<String, LocalDate>
     */
    Map<String, LocalDate> findLeapYearNames(List<Animal> animals);

    /**
     * найти всех животных,возраст которых старше N лет
     *
     * @param animals - массив животных
     * @param n       - количество лет
     * @return - мапа мапа Map<Animal, Integer>
     */
    Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int n);

    /**
     * Метод выводит на экран дубликаты животных
     *
     * @param animals - массив животных
     * @return - мапа Map<String, Integer>
     */
    Map<String, List<Animal>> findDuplicate(List<Animal> animals);

    /**
     * Cредний возраст всех животных
     *
     * @param animals - список животных
     * @return - возраст
     */
    BigDecimal findAverageAge(List<Animal> animals);

    /**
     * Найти животных, возраст которых больше 5 лет и стоимость которых больше средней стоимости всех животных
     *
     * @param animals - список животных
     * @return список животных
     */
    List<Animal> findOldAndExpensive(List<Animal> animals);

    /**
     * Найти 3 животных с самой низкой ценой, отсортированных в обратном алфавитном порядке.
     *
     * @param animals - список животных
     * @return список животных
     */
    List<Animal> findMinConstAnimals(List<Animal> animals);


}
