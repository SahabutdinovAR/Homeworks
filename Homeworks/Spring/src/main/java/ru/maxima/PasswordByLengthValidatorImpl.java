package ru.maxima;

public class PasswordByLengthValidatorImpl implements PasswordValidator {
    private int minLength;

    @Override
    public boolean isValid(String password) {
        if (!(password.length() >= minLength)) {
            System.err.println("Пароль найден в черном списке");
            return false;
        } else return true;
    }
}
