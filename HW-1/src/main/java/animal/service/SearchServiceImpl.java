package animal.service;

import animal.Animal;
import custexceptions.InvalidAnimalBirthDateException;
import custexceptions.InvalidAnimalException;

import java.util.Calendar;

/**
 * Класс, реализующий интерфейс SearchService
 */
public class SearchServiceImpl implements SearchService {
    /**
     * Выводит сообщение был ли Animal рожден в вискосный год
     */
    @Override
    public void checkLeapYearAnimal(Animal a) throws InvalidAnimalBirthDateException {
        if (a == null) {
            throw new InvalidAnimalException();
        }
        if (a.getBirthDate() == null) {
            throw new InvalidAnimalBirthDateException("У животного " + a.getClass().getSimpleName() + " не указана дата его рождения\n");
        }
        //Оказалось есть встроенная функция isLeapYear() :)
        /*
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, a.getBirthDate().getYear());
        boolean leapYear = cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
        System.out.println(a.getName() + (leapYear ? " был рожден в високосный год." : " не был рожден в високосный год."));
        */
        System.out.println(a.getName() + (a.getBirthDate().isLeapYear() ? " был рожден в високосный год." : " не был рожден в високосный год."));
    }
}