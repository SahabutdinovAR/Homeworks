package ru.maxima.observer.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Button exit = new ExitButton();
        exit.onClick(() -> System.exit(255));

        exit.click();
    }
}
