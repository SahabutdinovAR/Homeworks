package ru.maxima.validators.email;

import java.util.regex.Pattern;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
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
