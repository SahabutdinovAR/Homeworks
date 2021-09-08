package ru.maxima;

import java.util.StringJoiner;

/**
 * 14.08.2021
 * 31. Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User implements Comparable<User> {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private double height;

    public User(Long id, String firstName, String lastName, int age, double height) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .add("height=" + height)
                .toString();
    }

    // если мой объект < другого -> отрицательное число
    // если мой объект = другому -> 0
    // если мой объект > другого -> положительное число
    @Override
    public int compareTo(User o) {
        // если у меня возраст 25, а у другого объекта 27, то результат -> -2
        // если у меня возраст 25, а у другого объекта 25, то результат -> 0
        // если у меня возраст 27, а у другого объекта 25, то результат -> 2
        return this.age - o.age;
    }
}
