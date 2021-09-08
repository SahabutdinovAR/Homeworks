package ru.maxima.validators.password;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PasswordCharactersValidatorImpl implements PasswordValidator {
    @Override
    public boolean isValid(String password) {
        if (!(password.indexOf('&') != -1
                && password.indexOf('!') != -1
                && password.indexOf('*') != -1)) {
            System.err.println("Отсутствуют спец символы");
            return false;
        } else return true;
    }
}
