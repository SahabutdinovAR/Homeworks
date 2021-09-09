package repositories;

import com.zaxxer.hikari.HikariDataSource;
import jdk.nashorn.internal.objects.NativeFunction;
import models.User;
import util.IdGenerator;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryFileBasedImpl implements UsersRepository {

    private String fileName;

    private IdGenerator idGenerator;
    private NativeFunction userParsing;

    public UsersRepositoryFileBasedImpl(String fileName, IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.fileName = fileName;
    }

    public void save(User user) {
        // получили файл для записи
        File file = new File(fileName);
        // готовим переменную для записи информации в файл
        try (Writer out = new FileWriter(file, true);
             BufferedWriter writer = new BufferedWriter(out);) {
            // открыли текстовый поток для записи в файл
            // создали буферизированный поток для записи (это ускоряет работу)
            // записываем информацию о пользователе в файл
            user.setId(idGenerator.nextId());
            writer.write(user.getId() + "|" + user.getEmail() + "|" + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            // поскольку IOException - проверяемое, нам необходимо его обработать в любом случае
            // выбрасываем поверх непроверяемое исключение
            throw new IllegalStateException(e);
        }
    }

    public void update(User user) {
        try {
            HikariDataSource dataSource;
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getPassword());


            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Can't update");
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

        public Optional<User> findByEmail(String email) {
        File file = new File(fileName);
        try (Reader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader);) {
            // прочитал строку из файла
            String line = reader.readLine();
            // пока прочитанная строка не пустая
            while (line != null) {
                // разбили строку на два элемента до и после символа |
                String[] data = line.split("\\|");
                // если на этой линии указан искомый email
                if (data[1].equals(email)) {
                    // превратить эту строку в User и вернуть
                    User user = new User(data[1], data[2]);
                    return Optional.of(user);
                }
                // читаем новую
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    public List<User> findAll() {
        // список для пользователей
        List<User> users = new ArrayList<>();
        File file = new File(fileName);
        try (Reader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            // прочитал строку из файла
            String line = reader.readLine();
            // пока прочитанная строка не пустая
            while (line != null) {
                // разбили строку на два элемента до и после символа |
                String[] data = line.split("\\|");
                // создали пользователя на основе строки
                User user = new User(data[1], data[2]);
                // закидываем его в список
                users.add(user);
                // читаем новую
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return users;
    }
}
