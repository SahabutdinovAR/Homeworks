import dto.UserDto;
import ru.maxima.models.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryFileBasedImpl;
import services.UsersService;
import util.IdGenerator;
import util.IdGenerators;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Задача:
 * Предоставить функционал, который позволяет
 * 1. регистрировать пользователей (вводится их логин и пароль)
 * 2. аутентифицировать пользователей (вводится их логин и пароль, если они были зарегистрированы, то все ок)
 * 3. если пользователь аутентифицирован, то показать ему список пользователей, но, естественно, без паролей
 */
public class Main {

    public static void main(String[] args) {
        IdGenerator usersIdGenerator = IdGenerators.fileBasedGenerator("users_sequence.txt");
        UsersRepository usersRepository = new UsersRepositoryFileBasedImpl("users.txt", usersIdGenerator);
//        UsersRepository usersRepository = new UsersRepositoryListImpl();
        UsersService usersService = new UsersService(usersRepository);

        Scanner scanner = new Scanner(System.in);

        Optional<User> currentOptional = Optional.empty();
        while (true) {
            System.out.println("1. Регистрация");
            System.out.println("2. Аутентификация");
            System.out.println("3. Список пользователей");
            System.out.println("4. Изменить пароль");

            int command = scanner.nextInt();
            scanner.nextLine();

            if (command == 1) {
                String email = scanner.nextLine();
                String password = scanner.nextLine();
                usersService.signUp(email, password);
            } else if (command == 2) {
                String email = scanner.nextLine();
                String password = scanner.nextLine();
                currentOptional = usersService.signIn(email, password);

                if (!currentOptional.isPresent()) {
                    System.err.println("Ошибка аутентификации");
                }
            } else if (command == 3) {
                if (!currentOptional.isPresent()) {
                    System.err.println("Вы не прошли аутентификацию");
                    continue;
                }

                List<UserDto> users = usersService.getUsers(currentOptional.get());
                System.out.println(users);
            }
        }
    }
}
