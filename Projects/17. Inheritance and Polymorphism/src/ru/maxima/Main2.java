package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Athlete bolt = new Athlete("Усейн Болт", 35, 10);
        Workman marsel = new Workman("Марсель", 27, 10);
        Student maxim = new Student("Максим", 22, 4.5);

        Human a1 = bolt;
        Human a2 = marsel;
        Human a3 = maxim;

        // вызов переопределенных методов через переменную предка
        a1.run();
        a2.run();
        a3.run();

        Arena arena = new Arena();
        Human humans[] = {bolt, marsel, maxim};

        arena.start(humans);
    }
}
