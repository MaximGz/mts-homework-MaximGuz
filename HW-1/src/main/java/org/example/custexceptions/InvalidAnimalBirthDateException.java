package org.example.custexceptions;

/**
 * Exception при отсутствие даты рождения животного
 */
public class InvalidAnimalBirthDateException extends Exception {
    public InvalidAnimalBirthDateException(String message) {
        super(message);
    }
}
