package CustExecptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * RuntimeException при передаче null в качестве экземпляра животного
 */
public class InvalidAnimalException extends RuntimeException {
    private static final String ERROR_MESSAGE = "На вход пришёл некорректный объект животного";

    public InvalidAnimalException() {
        super(ERROR_MESSAGE + " " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
