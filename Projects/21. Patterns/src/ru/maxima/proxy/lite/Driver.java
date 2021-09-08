package ru.maxima.proxy.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public void drive() {
        System.out.println(name + " поехал!");
    }

    public String getName() {
        return name;
    }
}
