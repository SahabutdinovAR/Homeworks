package ru.maxima;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.maxima.repositories.AccountsRepository;
import ru.maxima.repositories.AccountsRepositoryJdbcImpl;

import javax.sql.DataSource;

/**
 * 24.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {

//        DataSource dataSource = new ConnectionPerRequestDataSource(
//                "postgres", "qwerty007", "jdbc:postgresql://localhost:5432/maxima_db");

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/maxima_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setMaximumPoolSize(20);

        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);

        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(accountsRepository.findAllOrderById());
        }
    }
}
