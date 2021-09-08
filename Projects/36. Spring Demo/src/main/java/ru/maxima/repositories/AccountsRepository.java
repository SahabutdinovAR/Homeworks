package ru.maxima.repositories;

import ru.maxima.models.Account;

import java.util.List;
import java.util.Optional;

/**
 * 20.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsRepository {
    void save(Account account);
}