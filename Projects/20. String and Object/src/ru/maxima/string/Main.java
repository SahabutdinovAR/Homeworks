package ru.maxima.string;

/**
 * 02.07.2021
 * 20. String and Object
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1.intern() == s3.intern()); // работает быстрее, чем equals
    }
}
