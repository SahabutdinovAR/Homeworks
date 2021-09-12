package ru.maxima;

import ru.maxima.models.Account;


public class SignUpService {

    private final PasswordBlackList passwordBlackList;

    private final SignUpDataValidator validator;

    private final AccountsRepository accountsRepository;

    public SignUpService(AccountsRepository accountsRepository, PasswordBlackList passwordBlackList, SignUpDataValidator validator) {
        this.accountsRepository = accountsRepository;
        this.passwordBlackList = passwordBlackList;
        this.validator = validator;
    }

    public void signUp(String email, String password) {
        if (!validator.isValid(email, password)) {
            return;
        }

        if (passwordBlackList.contains(password)) {
            return;
        }

        System.out.println("Регистрация прошла успешно!");

        Account account = Account.builder()
                .email(email)
                .password(password)
                .build();

        accountsRepository.save(account);
    }
}
