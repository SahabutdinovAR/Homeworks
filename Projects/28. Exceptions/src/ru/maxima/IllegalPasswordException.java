package ru.maxima;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class IllegalPasswordException extends RuntimeException {
    public IllegalPasswordException(String message) {
        super(message);
    }
}
