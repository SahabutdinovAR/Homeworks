package ru.maxima.repositories;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import ru.maxima.models.Account;

import java.util.HashMap;
import java.util.Map;

/**
 * 31.08.2021
 * 34. JdbcTemplate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class JdbcParamsUtil {
    public static MapSqlParameterSource getParamsForUpdate(Account account) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource
                .addValue("id", account.getId())
                .addValue("firstName", account.getFirstName())
                .addValue("lastName", account.getLastName())
                .addValue("age", account.getAge());

        return parameterSource;
    }

    public static MapSqlParameterSource getParamsForSave(Account account) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource
                .addValue("firstName", account.getFirstName())
                .addValue("lastName", account.getLastName())
                .addValue("age", account.getAge());

        return parameterSource;
    }
}
