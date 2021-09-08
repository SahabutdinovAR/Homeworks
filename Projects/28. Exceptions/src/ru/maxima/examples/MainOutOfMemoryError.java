package ru.maxima.examples;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainOutOfMemoryError {
    public static void main(String[] args) {
        int a[] = new int[Integer.MAX_VALUE];
    }
}
