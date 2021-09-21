package ru.maxima.repositories;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.maxima.models.Account;

import javax.sql.DataSource;


public class AccountsRepositoryNamedParametrJbbcTemplateImpl extends AccountsRepository {

    //language=SQL
    private static final String SQL_INSERT =
            "insert into account(email, password) values (:email, :password) RETURNING id";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AccountsRepositoryNamedParametrJbbcTemplateImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void save(Account account) {
        // данный объект запоминает сгенерированные базой данных ключи
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_INSERT, (new MapSqlParameterSource()
                .addValue("email", account.getEmail())
                .addValue("password", account.getPassword())), keyHolder, new String[]{"id"});
        account.setId(keyHolder.getKey().longValue());
    }
}
