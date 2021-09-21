package ru.maxima.validators.password;

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
