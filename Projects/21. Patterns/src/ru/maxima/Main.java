package ru.maxima;

import ru.maxima.strategy.Sequence;
import ru.maxima.strategy.SequenceArrayImpl;

public class Main {

    public static void main(String[] args) {
	    int array[] = {4, 77, 10, -5, 100, -78, 11, 4, 1, 20, -100, 1000};
        Sequence sequence = new SequenceArrayImpl(array);
        System.out.println(sequence.isExists(1));
    }
}
