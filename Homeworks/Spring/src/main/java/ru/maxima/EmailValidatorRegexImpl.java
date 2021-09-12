package ru.maxima;

import java.util.regex.Pattern;


public class EmailValidatorRegexImpl implements EmailValidator {

    private Pattern pattern;

    public void setRegex(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isValid(String email) {
        if (!pattern.matcher(email).find()) {
            System.err.println("Неверный формат email!");
            return false;
        } else return true;
    }
}
