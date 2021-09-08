package ru.maxima.app;

import ru.maxima.blacklist.PasswordBlackList;
import ru.maxima.blacklist.PasswordBlackListFileImpl;
import ru.maxima.SignUpService;
import ru.maxima.validators.email.EmailValidatorRegexImpl;
import ru.maxima.validators.password.PasswordCharactersValidatorImpl;
import ru.maxima.validators.SignUpDataValidator;
import ru.maxima.validators.SignUpDataValidatorEmailAndPasswordImpl;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
//        PasswordBlackList passwordBlackList = new PasswordBlackListHardcodeImpl();
        // список плохих паролей
        PasswordBlackList passwordBlackList = new PasswordBlackListFileImpl("bad_passwords.txt");
        // проверяет формат email по заданному регулярному выражению
        EmailValidatorRegexImpl emailValidator = new EmailValidatorRegexImpl();
        emailValidator.setRegex(".+@.+");
        // проверят длину пароля
//        PasswordByLengthValidator passwordValidator = new PasswordByLengthValidator();
//        passwordValidator.setMinLength(8);
        PasswordCharactersValidatorImpl passwordValidator = new PasswordCharactersValidatorImpl();
        // содержит логику проверки корректности данных, введенных пользователем
        SignUpDataValidator validator = new SignUpDataValidatorEmailAndPasswordImpl(passwordValidator, emailValidator);
        // содержит логику регистрации
        SignUpService signUpService = new SignUpService(null, passwordBlackList, validator);
        signUpService.signUp("sidikov.marsel@gmail.com", "simpledimple");
    }
}
