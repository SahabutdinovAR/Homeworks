package repositories;

import models.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository {
    void save(User user);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void update (User user);


}
