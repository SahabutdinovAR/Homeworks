package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Workman extends Human implements Worker {
    private int experience;

    public Workman(String name, int age, int experience) {
        super(name, age);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public void work() {
        System.out.println("Работаем!");
    }

    @Override
    public void getSalary() {
        System.out.println("Ура, я получил зарплату!");
    }

    @Override
    public void sayName() {
        System.out.println("Я рабочий человек - " + name);
    }
}
