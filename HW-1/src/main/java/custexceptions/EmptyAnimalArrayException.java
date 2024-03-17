package custexceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Исключение, если на вход был подан пустой массив Animals
 */
public class EmptyAnimalArrayException extends RuntimeException{
    private static final String ERROR_MESSAGE = "На вход подан пустой массив Animals";

    public EmptyAnimalArrayException() {
        super(ERROR_MESSAGE + " " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    public EmptyAnimalArrayException(String msg) {
        super(msg + " " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
