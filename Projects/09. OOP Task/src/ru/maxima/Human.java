package ru.maxima;

/**
 * 16.06.2021
 * 09. OOP Task
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {
    String name;
    private int age;

    Human(String name, int age) {
        this.name = name;
        setAge(age);
    }

    // метод доступа - геттер
    int getAge() {
        return age;
    }

    // метод доступа - сеттер
    void setAge(int age) {
        if (age <= 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }
}
