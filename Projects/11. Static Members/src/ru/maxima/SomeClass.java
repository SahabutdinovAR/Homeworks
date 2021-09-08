package ru.maxima;

import java.util.Random;

/**
 * 18.06.2021
 * 11. Static Members
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SomeClass {
    private static final int MAX_SIZE = 10;

    public int a;
    public static int b = 10;

    // статический инициализатор
    static {
        Random random = new Random();
        b = random.nextInt(100);
    }

    public void method() {
        System.out.println("a = " + a);
        System.out.println("static b = " + b);
        staticMethod();
    }

    public static void staticMethod() {
//        System.out.println("a = " + a);
        System.out.println("static b = " + b);
//        method();
    }
}
