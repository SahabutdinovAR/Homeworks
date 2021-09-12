package ru.maxima;

public class Main {
    public static void main(String[] args) {
        PasswordBlackList passwordBlackList = new PasswordBlackListFileImpl("bad_passwords.txt");
        // SignUpService signUp = new SignUpService(passwordBlackList);
        // signUpService.signUp("sahabutdinov@gmail.com", "qwerty");
        EmailValidatorRegexImpl emailValidator = new EmailValidatorRegexImpl();
        emailValidator.setRegex(".+@.+");
        PasswordCharactersValidatorImpl passwordValidator = new PasswordCharactersValidatorImpl();
        // содержит логику проверки корректности данных, введенных пользователем
        SignUpDataValidator validator = new SignUpDataValidatorEmailAndPasswordImpl(passwordValidator, emailValidator);
        // содержит логику регистрации
        SignUpService signUpService = new SignUpService(null, passwordBlackList, validator);
        signUpService.signUp("sidikov.marsel@gmail.com", "simpledimple");

    }
}
