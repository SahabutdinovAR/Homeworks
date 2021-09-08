package ru.maxima.streams;

import ru.maxima.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 14.08.2021
 * 31. Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main1 {
    public static void main(String[] args) {
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
        // преобразую список в поток данных
        Stream<User> userStream = users.stream();

        // boolean test(T t);
        Predicate<User> ageMoreThan22 = user -> user.getAge() > 22;
        // int compare(T o1, T o2);
        Comparator<User> userByAgeComparator = (o1, o2) -> o1.getAge() - o2.getAge();
        // R apply(T t);
        Function<User, String> getNameOfUser = user -> user.getFirstName() + " " + user.getLastName();
        // void accept(T t);
        Consumer<User> printUser = user -> System.out.println(user);
        Consumer<String> printName = name -> System.out.println(name);

        // получить поток данных, в котором остались только те пользователи, которым больше 22-х лет
        Stream<User> filteredStream = userStream.filter(ageMoreThan22);
        Stream<User> sortedStream = filteredStream.sorted(userByAgeComparator);
        Stream<String> namesStream = sortedStream.map(getNameOfUser);
        namesStream.forEach(printName);
    }
}
