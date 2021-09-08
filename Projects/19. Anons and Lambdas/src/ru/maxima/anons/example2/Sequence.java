package ru.maxima.anons.example2;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class Sequence {

    protected int array[];

    public Sequence(int[] elements) {
        this.array = elements;
    }

    public abstract void sort();

    public abstract boolean search(int element);
}
