package ru.maxima.custom;

import ru.maxima.IllegalPasswordException;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PasswordValidator {
    public void validate(String password) {
        if (!(password.matches("[A-Z]+[a-z]+[0-9]+") && password.length() > 5)) {
//            throw new IllegalArgumentException("Пароль некрасивый");
            throw new IllegalPasswordException("Пароль некрасивый");
        }
    }
}
