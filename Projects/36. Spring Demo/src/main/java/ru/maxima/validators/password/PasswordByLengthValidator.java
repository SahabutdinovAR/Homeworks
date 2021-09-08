package ru.maxima.validators.password;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PasswordByLengthValidator implements PasswordValidator {

    private int minLength;

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean isValid(String password) {
        if (!(password.length() >= minLength)) {
            System.err.println("Длина пароля не соответствует требованиям!");
            return false;
        } else return true;
    }
}
