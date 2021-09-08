import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.maxima.models.Account;
import ru.maxima.repositories.AccountsRepository;
import ru.maxima.repositories.AccountsRepositoryJdbcTemplateImpl;
import ru.maxima.repositories.AccountsRepositoryNamedParameterJdbcTemplateImpl;

import java.io.IOException;
import java.util.Properties;

/**
 * 26.08.2021
 * 34. JdbcTemplate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(Main.class.getResourceAsStream("db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        HikariDataSource dataSource = new HikariDataSource(new HikariConfig(properties));
        AccountsRepository accountsRepository = new AccountsRepositoryNamedParameterJdbcTemplateImpl(dataSource);

        for (Account account : accountsRepository.findAllOrderById()) {
            System.out.println(account);
        }
    }
}
