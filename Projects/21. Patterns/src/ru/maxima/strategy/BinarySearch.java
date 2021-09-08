package ru.maxima.strategy;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BinarySearch implements SearchAlgorithm {

    private Sequence sequence;

    public BinarySearch(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean search(int element) {
        System.out.println("Бинарный поиск");
        int elements[] = sequence.toArray();
        sort(elements);

        int left = 0;
        int right = elements.length - 1;
        int middle;

        while (left <= right) {
            middle = (right + left) / 2;

            if (elements[middle] < element) {
                left = middle + 1;
            } else if (elements[middle] > element) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private void sort(int sequence[]) {
        System.out.println("Сортировка");
        for (int i = 0; i < sequence.length; i++) {
            int min = sequence[i];
            int indexOfMin = i;

            for (int j = i; j < sequence.length; j++) {
                if (sequence[j] < min) {
                    min = sequence[j];
                    indexOfMin = j;
                }
            }

            sequence[indexOfMin] = sequence[i];
            sequence[i] = min;
        }
    }
}
