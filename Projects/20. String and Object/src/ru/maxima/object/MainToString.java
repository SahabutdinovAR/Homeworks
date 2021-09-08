package ru.maxima.object;

import java.util.Scanner;

/**
 * 02.07.2021
 * 20. String and Object
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Human human = new Human("Марсель", 27);

        Object o1 = scanner;
        Object o2 = human;

        Human h1 = null;
        System.out.println(human);
    }
}
