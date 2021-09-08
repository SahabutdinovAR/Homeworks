package ru.maxima.repositories;

import ru.maxima.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 22.07.2021
 * 27. SimpleProgram
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryListImpl implements UsersRepository {
    private List<User> users;

    public UsersRepositoryListImpl() {
        this.users = new ArrayList<>();
    }

    public void save(User user) {
        this.users.add(user);
    }

    public Optional<User> findByEmail(String email) {
        // пробегаемся по всему списку, благодаря Iterable
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        // если не нашли ни одного человека с таким email, то возвращаем null
        return Optional.empty();
    }

    public List<User> findAll() {
        return users;
    }
}
