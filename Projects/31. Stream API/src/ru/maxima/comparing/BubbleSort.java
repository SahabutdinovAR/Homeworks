package ru.maxima.comparing;

import java.util.Comparator;

/**
 * 14.08.2021
 * 31. Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BubbleSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort0(array, null);
    }

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        sort0(array, comparator);
    }

    private static <T> void sort0(T[] array, Comparator<T> comparator) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int compareResult;

                if (comparator != null) {
                    compareResult = comparator.compare(array[j], array[j + 1]);
                } else {
                    Comparable<T> a = (Comparable<T>) array[j];
                    T b = array[j + 1];
                    compareResult = a.compareTo(b);
                }

                if (compareResult > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
