package ru.maxima.repositories;

import ru.maxima.models.Account;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * 20.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AccountsRepositoryJdbcImpl implements AccountsRepository {

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
            "insert into account(first_name, last_name, age) values (?, ?, ?)";

    private DataSource dataSource;

    private final Function<ResultSet, Account> rowToAccountMapper = row -> {
        try {
            return new Account(
                    row.getLong("id"),
                    row.getString("first_name"),
                    row.getString("last_name"),
                    row.getInt("age")
            );
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    };

    public AccountsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Account account) {
        try {
            // RETURN_GENERATED_KEYS - флаг, который говорит
            // что из запроса нужно вытащить значения, которые сгенерировала БД
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setInt(3, account.getAge());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Can't insert");
            }
            // получили сгенерированные ключи
            ResultSet generatedKeys = statement.getGeneratedKeys();
            // если вы не можете получить сгенерированные ключи (которых нет)
            if (!generatedKeys.next()) {
                throw new SQLException("Can't retrieve generated keys");
            }
            // положили в модель сгенерированный базой id
            account.setId(generatedKeys.getLong("id"));

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setInt(3, account.getAge());
            statement.setLong(4, account.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Can't update");
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(Account account) {
        // TODO: реализовать
    }

    @Override
    public Optional<Account> findById(Long id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            // вместо первого вопросительного знака подставили идентификатор искомого аккаунта
            preparedStatement.setLong(1, id);

            try (ResultSet result = preparedStatement.executeQuery()) {
                if (!result.next()) {
                    return Optional.empty();
                }
                // если найден, возвращаем его в обертке
                Account account = rowToAccountMapper.apply(result);

                return Optional.of(account);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Account> findAllOrderById() {
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(SQL_SELECT_ALL)) {

            while (result.next()) {
                Account account = rowToAccountMapper.apply(result);
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return accounts;
    }
}
