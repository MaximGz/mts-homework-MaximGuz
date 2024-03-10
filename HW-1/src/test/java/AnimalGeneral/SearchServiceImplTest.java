package AnimalGeneral;

import CustExecptions.InvalidAnimalBirthDateException;
import CustExecptions.InvalidAnimalException;
import PetAnimals.*;
import PredatorAnimals.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.*;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
        a.name = "Test";
        a.birthDate = LocalDate.of(year, 1, 1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirect System.out to capture output

        ssi.checkLeapYearAnimal(a);

        String expectedOutput = "Test был рожден в високосный год.\r\n"; // Expected output when born in a leap year
        assertEquals(expectedOutput, outContent.toString()); // Check if the output matches the expected output
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
        a.name = "Test";
        a.birthDate = LocalDate.of(year, 1, 1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ssi.checkLeapYearAnimal(a);

        String expectedOutput = "Test не был рожден в високосный год.\r\n";
        assertEquals(expectedOutput, outContent.toString());
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
        a.birthDate = null;

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
            try {
                ssi.checkLeapYearAnimal(val);
            } catch (NullPointerException e) {
                throw new InvalidAnimalException();
            } catch (InvalidAnimalBirthDateException e) {
                throw new RuntimeException(e);
            }
        });
    }

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
}