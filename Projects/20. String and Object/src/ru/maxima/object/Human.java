package ru.maxima.object;

/**
 * 02.07.2021
 * 20. String and Object
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {
    private int age;
    private String name;

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human[" + "age - " + age +", name - " + name + "]";
    }
}
