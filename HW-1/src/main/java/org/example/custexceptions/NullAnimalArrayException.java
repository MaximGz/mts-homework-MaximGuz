package org.example.custexceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Исключение, если на вход был подан null вместо массива Animal[]
 */
public class NullAnimalArrayException extends RuntimeException {
    private static final String ERROR_MESSAGE = "На вход подан null, ожидался массив Animal";
    public NullAnimalArrayException() {
        super(ERROR_MESSAGE + " " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    public NullAnimalArrayException(String msg) {
        super(msg + " " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
