package ru.maxima.validators.password;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface PasswordValidator {
    boolean isValid(String password);
}
