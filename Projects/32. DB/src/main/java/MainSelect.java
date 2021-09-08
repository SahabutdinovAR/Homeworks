import java.sql.*;

/**
 * 20.08.2021
 * 32. DB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainSelect {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maxima_db",
                    "postgres", "qwerty007");

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("select * from account");

            while (result.next()) {
                System.out.println(result.getString("first_name") + " "
                        + result.getString("last_name") + " "
                        + result.getInt("age"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
