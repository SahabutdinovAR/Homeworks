package ru.maxima;

public interface SignUpDataValidator {
    boolean isValid(String password, String email);
}