package ru.maxima.validators;

import ru.maxima.validators.email.EmailValidator;
import ru.maxima.validators.password.PasswordValidator;

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
