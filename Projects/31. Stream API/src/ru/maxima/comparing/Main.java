package ru.maxima.comparing;

import ru.maxima.User;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
//        Scanner[] scanners = {new Scanner(System.in), new Scanner(System.in), new Scanner(System.in)};
//        BubbleSort.sort(scanners);

        Integer[] numbers = {43, 10, -15, 1000, 55, 28, 26, 30};
        BubbleSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        User user0 = new User(40L, "Марсель", "Сидиков", 28, 1.85);
        User user1 = new User(7L, "Алия", "Мухутдинова", 21, 1.73);
        User user2 = new User(13L, "Виктор", "Евлампьев", 24, 1.78);
        User user3 = new User(44L, "Айрат", "Мухутдинов", 22, 1.85);
        User user4 = new User(1L, "Даниил", "Вдовинов", 21, 1.75);
        User user5 = new User(15L, "Максим", "Поздеев", 22, 1.68);
        User user6 = new User(9L, "Салават", "Забиров", 25, 1.73);
        User user7 = new User(2L, "Ильгам", "Хасанов", 24, 1.80);

        User[] users = {user0, user1, user2, user3, user4, user5, user6, user7};

//        BubbleSort.sort(users);
//        BubbleSort.sort(users, new UserByHeightComparator());

        // BubbleSort.sort(users, (o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight()));
        // тут лямбда выражение
        // оба объекта одного типа, у обоих вызывается getHeight и сравнивается через Double.compare
        // это значит, что Javе не нужно все так подробно описывать
        // Comparator - это интерфейс, в котором есть так называемый статический default-метод
        // comparingDouble - что он принимает на вход?
        // Он принимает на вход ToDoubleFunction
        // в котором есть
        // double applyAsDouble(T value); - задача этого метода из value вытащить double
        // в нашем случае o1.getHeight() или o2.getHeight() как раз применяются как applyAsDouble
        BubbleSort.sort(users, Comparator.comparingDouble(User::getHeight));

        System.out.println(Arrays.toString(users));
    }
}
