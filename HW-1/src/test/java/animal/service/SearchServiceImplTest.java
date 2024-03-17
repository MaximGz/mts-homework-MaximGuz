package animal.service;

import animal.AbstractAnimal;
import animal.Animal;
import animal.pet.Cat;
import animal.pet.Cow;
import animal.pet.Dog;
import animal.predator.Lion;
import animal.predator.Shark;
import animal.predator.Wolf;
import custexceptions.InvalidAnimalBirthDateException;
import custexceptions.InvalidAnimalException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Класс для тестирования
 */
class SearchServiceImplTest {
    SearchServiceImpl ssi = new SearchServiceImpl();
    /**
     * Проверка на корректность вискосного года
     *
     * @param year - високосный год для проверкм
     * @throws InvalidAnimalBirthDateException - исключение "не заполнена дата рождения"
     */
    @DisplayName("Високосный год")
    @ParameterizedTest
    @ValueSource(ints = {2000, 2004, 2008, 2012, 2016, 2020, 2024})
    void checkTrueLeapYearAnimal(Integer year) throws InvalidAnimalBirthDateException {
        AbstractAnimal a = new Cat();
        a.setName("Test");
        a.setBirthDate(LocalDate.of(year, 1, 1));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ssi.checkLeapYearAnimal(a);

        String expectedOutput = "Test был рожден в високосный год.\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Проверка на корректность не вискосного года
     *
     * @param year - не високосный год для проверкм
     * @throws InvalidAnimalBirthDateException - исключение "не заполнена дата рождения"
     */
    @DisplayName("Не високосный год")
    @ParameterizedTest
    @ValueSource(ints = {2001, 2002, 2003, 2005, 2006, 2007, 2009})
    void checkFalseLeapYearAnimal(Integer year) throws InvalidAnimalBirthDateException {
        AbstractAnimal a = new Cat();
        a.setName("Test");
        a.setBirthDate(LocalDate.of(year, 1, 1));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ssi.checkLeapYearAnimal(a);

        String expectedOutput = "Test не был рожден в високосный год.\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    //просто для теста аннотации MethodSource, логика необязательна
    private static Stream<Arguments> fetchData() {
        return Stream.of(
                Arguments.arguments(new Cat()),
                Arguments.arguments(new Dog()),
                Arguments.arguments(new Cow()),
                Arguments.arguments(new Lion()),
                Arguments.arguments(new Shark()),
                Arguments.arguments(new Wolf())
        );
    }

    /**
     * Проверка на исключение InvalidAnimalBirthDateException
     *
     * @param a - экзмепляр класса AbstractAnimal или его потомки
     */
    @DisplayName("Исключение InvalidAnimalBirthDateException")
    @ParameterizedTest
    @MethodSource("fetchData")
    void checkLeapYearAnimalException(AbstractAnimal a) {
        a.setBirthDate(null);

        assertThrows(InvalidAnimalBirthDateException.class, () -> ssi.checkLeapYearAnimal(a));
    }

    /**
     * Проверка на исключение InvalidAnimalException
     */
    @DisplayName("Исключение InvalidAnimalException")
    @ParameterizedTest
    @NullSource
    void checkInvalidAnimalException(Animal val) {
        assertThrows(InvalidAnimalException.class, () -> {
            ssi.checkLeapYearAnimal(val);
        });
    }
}