import java.sql.*;
import java.util.Scanner;

/**
 * 20.08.2021
 * 32. DB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainInsert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int age = scanner.nextInt();

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maxima_db",
                    "postgres", "qwerty007");

            PreparedStatement statement =
                    connection.prepareStatement("insert into account(first_name, last_name, age) values (?, ?, ?)");

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            // сколько строк было изменено?
            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Cant' insert");
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
