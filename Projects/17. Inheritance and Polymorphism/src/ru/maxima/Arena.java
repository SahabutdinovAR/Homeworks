package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Arena {
    // в этот метод можно передать и людей, и студентов, и атлетов, при этом у все есть метод run
    // но у каждого он может быть реализован по-своему
    public void start(Human[] humans) {
        for (int i = 0; i < humans.length; i++) {
            humans[i].sayName();
            humans[i].run();
        }
    }
}
