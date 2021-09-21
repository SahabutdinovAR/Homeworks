package ru.maxima.validators;

public interface SignUpDataValidator {
    boolean isValid(String password, String email);
}