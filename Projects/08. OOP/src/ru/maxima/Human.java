package ru.maxima;

/**
 * 16.06.2021
 * 08. OOP
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {
    // поля (fields) - конкретные значения полей определяют состояние объекта
    double height;
    boolean isWorker;

    void work() {
        isWorker = true;
    }

    void relax() {
        isWorker = false;
    }

    void grow(double value) {
        height += value;
    }
}
