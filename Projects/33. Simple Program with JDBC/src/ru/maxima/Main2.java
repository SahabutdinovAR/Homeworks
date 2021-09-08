package ru.maxima;

import ru.maxima.repositories.AccountsRepository;
import ru.maxima.repositories.AccountsRepositoryJdbcImpl;
import ru.maxima.util.OncePerQueryDataSource;

import javax.sql.DataSource;

/**
 * 24.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) throws Exception {

        DataSource dataSource = new OncePerQueryDataSource(
                "postgres", "qwerty007", "jdbc:postgresql://localhost:5432/maxima_db");

        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);

        for (int i = 0; i < 100; i++) {
            accountsRepository.findAllOrderById();
        }
    }
}
