package services;

import dto.UserDto;
import ru.maxima.models.User;
import repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dto.UserDto.from;

public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void signUp(String email, String password) {
        User user = new User(email, password);
        usersRepository.save(user);
    }

    public Optional<User> signIn(String email, String password) {
        // получили пользователя по его email
        Optional<User> userOptional = usersRepository.findByEmail(email);
        // если пользователь есть, и у него совпал пароль, то делаем его аутентифицированным
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            User user = userOptional.get();
            user.setAuthenticated(true);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public List<UserDto> getUsers(User me) {
        if (me.isAuthenticated()) {
            return from(usersRepository.findAll());
        }
        return new ArrayList<>();
    }
}
