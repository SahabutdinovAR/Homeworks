package ru.maxima.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.maxima.models.Account;
import ru.maxima.models.Car;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static ru.maxima.repositories.JdbcParamsUtil.getParamsForSave;
import static ru.maxima.repositories.JdbcParamsUtil.getParamsForUpdate;

/**
 * 20.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AccountsRepositoryNamedParameterJdbcTemplateImpl implements AccountsRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select a.id as account_id, c.id as car_id, * " +
            "from account a " +
            "         left join car c on a.id = c.owner_id " +
            "order by account_id;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "select a.id as account_id, c.id as car_id, * from account a left join car c on a.id = c.owner_id where a.id = :id;";

    //language=SQL
    private static final String SQL_UPDATE_BY_ID =
            "update account set first_name = :firstName, last_name = :lastName, age = :age where id = :id;";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into account(first_name, last_name, age) values (:firstName, :lastName, :age) RETURNING id";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<Account> accountRowMapper = (row, rowNumber) -> Account.builder()
            .id(row.getLong("account_id"))
            .age(row.getInt("age"))
            .lastName(row.getString("first_name"))
            .firstName(row.getString("last_name"))
            .cars(new ArrayList<>())
            .build();

    private final RowMapper<Car> carRowMapper = (row, rowNum) -> Car.builder()
            .id(row.getLong("car_id"))
            .color(row.getString("color"))
            .model(row.getString("model"))
            .build();

    private final ResultSetExtractor<Account> accountResultSetExtractor = resultSet -> {
        Account account = null;
        if (resultSet.next()) {
            // обработали первую строку с данными пользователя
            account = accountRowMapper.mapRow(resultSet, 0);

            // проверяем, есть ли на этой же строке машина
            if (resultSet.getObject("car_id") != null) {
                // получили первую машину
                Car car = carRowMapper.mapRow(resultSet, 0);
                // положили ей владельца
                car.setOwner(account);
                // положим эту машину владельцу
                account.getCars().add(car);
            }
            // докидываем оставшиеся машины
            while (resultSet.next()) {
                Car car = carRowMapper.mapRow(resultSet, 0);
                // положили ей владельца
                car.setOwner(account);
                // положим эту машину владельцу
                account.getCars().add(car);
            }
        }

        return account;
    };

    private final ResultSetExtractor<List<Account>> accountsResultSetExtractor = resultSet -> {
        boolean rowsAvailable = resultSet.next();
        List<Account> accounts = new ArrayList<>();

        // пока есть что смотреть
        while (rowsAvailable) {
            // получил пользователя с текущей строки
            Account account = accountRowMapper.mapRow(resultSet, 0);
            // пока это тот же самый пользователь и пока у него есть машина мы запоминаем эти машины
            while (resultSet.getLong("account_id") == account.getId()
                    && resultSet.getObject("car_id") != null) {
                Car car = carRowMapper.mapRow(resultSet, 0);
                account.getCars().add(car);
                // переходим к следующей строке
                rowsAvailable = resultSet.next();
            }

            if (resultSet.getObject("car_id") == null) {
                rowsAvailable = resultSet.next();
            }

            // добавили пользователя
            accounts.add(account);
        }


        return accounts;
    };

    public AccountsRepositoryNamedParameterJdbcTemplateImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void save(Account account) {
        // данный объект запоминает сгенерированные базой данных ключи
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_INSERT, getParamsForSave(account), keyHolder, new String[]{"id"});
        account.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Account account) {
        namedParameterJdbcTemplate.update(SQL_UPDATE_BY_ID, getParamsForUpdate(account));
    }

    @Override
    public void delete(Account account) {
        // TODO: реализовать
    }

    @Override
    public Optional<Account> findById(Long id) {
        try {
            return Optional.of(namedParameterJdbcTemplate.query(SQL_SELECT_BY_ID,
                    Collections.singletonMap("id", id), accountResultSetExtractor));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Account> findAllOrderById() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL, accountsResultSetExtractor);
    }
}
