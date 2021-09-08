import java.sql.*;
import java.util.Scanner;

/**
 * 20.08.2021
 * 32. DB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainSqlInjection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int age = scanner.nextInt();

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maxima_db",
                    "postgres", "qwerty007");

            Statement statement = connection.createStatement();
            //language=sql
            String sql = "insert into account(first_name, last_name, age) values ('" + firstName + "', '" + lastName + "', " + age + ");";
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
