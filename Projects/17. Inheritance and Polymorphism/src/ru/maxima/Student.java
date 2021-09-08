package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Student extends Human implements Beneficiary {
    private double averageMark;

    public Student(String name, int age, double averageMark) {
        super(name, age);
        this.averageMark = averageMark;
    }

    @Override
    public void run() {
        System.out.println("Студент побежал и сделал пять шагов!");
        this.stepsCount += 5;
    }

    @Override
    public void sayName() {
        System.out.println("Я студент - " + name);
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public void getBenefit() {
        System.out.println("Получил стипендию 200 рублей...");
    }
}
