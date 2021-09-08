package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class Human {
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;
    private static final String DEFAULT_NAME = "DEFAULT_NAME";
    private static final int STEP_VALUE_FOR_GO = 1;
    private static final int STEP_VALUE_FOR_RUN = 10;

    protected String name;
    protected int age;

    protected int stepsCount;

    public Human(String name, int age) {
        if (name == null) {
            this.name = DEFAULT_NAME;
        } else {
            this.name = name;
        }

        if (age >= MIN_AGE && age <= MAX_AGE) {
            this.age = age;
        } else {
            this.age = MIN_AGE;
        }

        this.stepsCount = 0;
    }

    public void go() {
        System.out.println(name + " пошел");
        this.stepsCount += STEP_VALUE_FOR_GO;
    }

    public void run() {
        System.out.println(name + " побежал");
        this.stepsCount += STEP_VALUE_FOR_RUN;
    }

    public abstract void sayName();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStepsCount() {
        return stepsCount;
    }
}
