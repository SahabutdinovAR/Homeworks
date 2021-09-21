package ru.maxima.validators.password;


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
