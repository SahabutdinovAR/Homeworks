package repositories;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @Override
    public void update(User user) {

    }
}
