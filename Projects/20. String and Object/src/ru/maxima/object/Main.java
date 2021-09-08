package ru.maxima.object;

import java.util.Scanner;

/**
 * 02.07.2021
 * 20. String and Object
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    public static void main(String[] args) {
        Point a = new Point(5, 7, 9);
        Point b = new Point(5, 7, 9);
        Point d = new Point(5, 7, 9);
        Point f = new Point(5, 7, 9);

//        Point[] points = {a, b, d, f};
        System.out.println("EqualsUtil - " + EqualsUtil.isEquals(a, b, d, f));

        Scanner scanner = new Scanner(System.in);

        // == сравнивает значения переменных, ссылки, которые содержатся внутри переменных не равны
        // следовательно результат будет false
        System.out.println(a == b);
        // метод equals в классе Object, позволяет сравнивать значения объектов, а не ссылки
        System.out.println(a.equals(b));

        Point c = null;
        System.out.println(a.equals(c));
        System.out.println(a.equals(a));
        System.out.println(a.equals(scanner));

        System.out.println(EqualsUtil.isEquals("Привет", "Приветик", "Привет"));
    }
}
