package ru.maxima.simple;

/**
 * 22.06.2021
 * 16. Builder
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Number {
    private int value;

    public Number() {
        this.value = 0;
    }

    public Number plus(int value) {
        this.value += value;
        return this;
    }

    public Number minus(int value) {
        this.value -= value;
        return this;
    }

    public int getValue() {
        return value;
    }
}
