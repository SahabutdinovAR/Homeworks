package ru.maxima.example2;

import ru.maxima.example1.Human;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Привет");
        list.add("Как дела");
        list.add("Что нового?");
//        list.add(new Scanner(System.in));

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            // этот код полагает, что у нас с вами список состоит из строк, но никакой гарантии этому нет
            // в итоге получили ошибку
            // следовательно данный код не соблюдает безопасность типов
            String value = iterator.next();
            System.out.println("Значение из списка: " + value);
        }

        List<Human> humans = new ArrayList<>();
//        humans.add("Привет");
//        humans.add(new Scanner(System.in));
        humans.add(new Human("Даниил", 21));
        humans.add(new Human("Максим", 21));
        humans.add(new Human("Айрат", 22));
        humans.add(new Human("Марсель", 27));

        Iterator<Human> humanIterator = humans.iterator();

        while (iterator.hasNext()) {
            Human human = humanIterator.next();
            System.out.println(human);
        }
    }
}
