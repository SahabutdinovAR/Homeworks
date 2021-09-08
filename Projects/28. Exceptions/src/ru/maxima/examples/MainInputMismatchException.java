package ru.maxima.examples;

import java.util.Scanner;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainInputMismatchException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
    }
}
