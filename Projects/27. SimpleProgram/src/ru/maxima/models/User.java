package ru.maxima.models;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 22.07.2021
 * 27. SimpleProgram
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private int id;
    private String email;
    private String password;
    private boolean isAuthenticated = false;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
