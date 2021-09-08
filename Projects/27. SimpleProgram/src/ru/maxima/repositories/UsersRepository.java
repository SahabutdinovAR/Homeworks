package ru.maxima.repositories;

import ru.maxima.models.User;

import java.util.List;
import java.util.Optional;

/**
 * 06.08.2021
 * 27. SimpleProgram
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository {
    void save(User user);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    // void update(User user);
}
