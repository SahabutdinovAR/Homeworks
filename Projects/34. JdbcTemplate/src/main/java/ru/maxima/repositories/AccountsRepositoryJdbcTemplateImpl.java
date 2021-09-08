package ru.maxima.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.maxima.models.Account;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 20.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AccountsRepositoryJdbcTemplateImpl implements AccountsRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "select id, first_name, last_name, age from account where id = ?";

    //language=SQL
    private static final String SQL_UPDATE_BY_ID =
            "update account set first_name = ?, last_name = ?, age = ? where id = ?;";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into account(first_name, last_name, age) values (?, ?, ?) RETURNING id";

    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Account> accountRowMapper = (row, rowNumber) -> new Account(
            row.getLong("id"),
            row.getString("first_name"),
            row.getString("last_name"),
            row.getInt("age"),
            new ArrayList<>());

    public AccountsRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Account account) {
        // данный объект запоминает сгенерированные базой данных ключи
        KeyHolder keyHolder = new GeneratedKeyHolder();
       jdbcTemplate.update(connection -> {
           PreparedStatement statement =
                   connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, account.getFirstName());
           statement.setString(2, account.getLastName());
           statement.setInt(3, account.getAge());
           return statement;
       } , keyHolder);
       account.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID,
                account.getFirstName(),
                account.getLastName(),
                account.getAge(),
                account.getId());
    }

    @Override
    public void delete(Account account) {
        // TODO: реализовать
    }

    @Override
    public Optional<Account> findById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, accountRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Account> findAllOrderById() {
        return jdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }
}
