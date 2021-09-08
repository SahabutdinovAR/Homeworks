package ru.maxima;

import ru.maxima.models.Account;
import ru.maxima.repositories.AccountsRepository;
import ru.maxima.repositories.AccountsRepositoryJdbcImpl;
import ru.maxima.util.OncePerQueryDataSource;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new OncePerQueryDataSource(
                "postgres", "qwerty007", "jdbc:postgresql://localhost:5432/maxima_db");

        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);
        Account newUser = new Account("Джет", "Ли", 59);
        System.out.println(newUser);
        accountsRepository.save(newUser);
        System.out.println(newUser);
//            System.out.println(accountsRepository.findAllOrderById());

//            Optional<Account> accountOptional = accountsRepository.findById(1L);
//
//            if (accountOptional.isPresent()) {
//                Account account = accountOptional.get();
//                account.setAge(99);
//                account.setLastName("Ситдиков");
//                accountsRepository.update(account);
//            } else {
//                System.out.println("Ничего не нашли");
//            }

    }
}
