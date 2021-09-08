package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Athlete extends Human implements Worker, Beneficiary {
    private static final int ATHLETE_STEP_VALUE_FOR_RUN = 20;
    private static final int DEFAULT_RANK = 0;

    private int rank;

    public Athlete(String name, int age, int rank) {
        // вызвать конструктор класса предка
        super(name, age);

        if (rank >= DEFAULT_RANK) {
            this.rank = rank;
        } else {
            this.rank = DEFAULT_RANK;
        }
    }

    // данный метод объявлен в классе предке, но при этом, у нас здесь другая реализация
    // методы, для которых указывается другая реализация в потомке при той же самой сигнатуре
    // называются переопределенными (Override)
    @Override
    public void run() {
        System.out.println("Спортсмен - " + name + " побежал");
        this.stepsCount += ATHLETE_STEP_VALUE_FOR_RUN;
    }

    @Override
    public void sayName() {
        System.out.println("Я спортсмен - " + name);
    }

    public int getRank() {
        return rank;
    }

    @Override
    public void work() {
        System.out.println("Ну, я побежал!");
    }

    @Override
    public void getSalary() {
        System.out.println("Набегал на 1000000$");
    }

    @Override
    public void getBenefit() {
        System.out.println("Получил еще 1000000$ в качестве льготы :)");
    }
}
