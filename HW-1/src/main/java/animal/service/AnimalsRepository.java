package animal.service;

import animal.Animal;

import java.time.LocalDate;
import java.util.Map;

/**
 * Интерфейс AnimalRepository
 */
public interface AnimalsRepository {

    /**
     * найти всех животных, которые родились в високосный год
     * @param animals - массив животных
     * @return - мапа Map<String, LocalDate>
     */
    Map<String, LocalDate> indLeapYearNames(Animal[] animals);

    /**
     * найти всех животных,возраст которых старше N лет
     * @param animals - массив животных
     * @param n - количество лет
     * @return - мапа мапа Map<Animal, Integer>
     */
    Map<Animal, Integer> findOlderAnimal(Animal[] animals, int n);

    /**
     * Метод выводит на экран дубликаты животных
     * @param animals - массив животных
     * @return - мапа Map<String, Integer>
     */
    Map<String, Integer> findDuplicate(Animal[] animals);
}
