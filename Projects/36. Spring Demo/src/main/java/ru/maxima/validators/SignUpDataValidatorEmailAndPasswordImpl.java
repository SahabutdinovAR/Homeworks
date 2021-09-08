package ru.maxima.validators;

import ru.maxima.validators.email.EmailValidator;
import ru.maxima.validators.password.PasswordValidator;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SignUpDataValidatorEmailAndPasswordImpl implements SignUpDataValidator {

    private final PasswordValidator passwordValidator;
    private final EmailValidator emailValidator;

    public SignUpDataValidatorEmailAndPasswordImpl(PasswordValidator passwordValidator, EmailValidator emailValidator) {
        this.passwordValidator = passwordValidator;
        this.emailValidator = emailValidator;
    }

    @Override
    public boolean isValid(String email, String password) {
        return emailValidator.isValid(email) && passwordValidator.isValid(password);
    }
}
