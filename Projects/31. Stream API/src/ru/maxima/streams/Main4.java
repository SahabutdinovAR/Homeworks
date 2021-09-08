package ru.maxima.streams;

import ru.maxima.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 14.08.2021
 * 31. Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main4 {

    private static List<User> usersList() {
        User user0 = new User(40L, "Марсель", "Сидиков", 28, 1.85);
        User user1 = new User(7L, "Алия", "Мухутдинова", 21, 1.73);
        User user2 = new User(13L, "Виктор", "Евлампьев", 24, 1.78);
        User user3 = new User(44L, "Айрат", "Мухутдинов", 22, 1.85);
        User user4 = new User(1L, "Даниил", "Вдовинов", 21, 1.75);
        User user5 = new User(15L, "Максим", "Поздеев", 22, 1.68);
        User user6 = new User(9L, "Салават", "Забиров", 25, 1.73);
        User user7 = new User(2L, "Ильгам", "Хасанов", 24, 1.80);

        List<User> users = new ArrayList<>();
        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        return users;
    }

    public static void main(String[] args) {
        usersList()
                .stream()
                .filter(user -> user.getAge() > 22)
                .sorted(Comparator.comparingInt(User::getAge))
                .map(user -> user.getFirstName() + " " + user.getLastName())
                .forEach(System.out::println);
    }
}
