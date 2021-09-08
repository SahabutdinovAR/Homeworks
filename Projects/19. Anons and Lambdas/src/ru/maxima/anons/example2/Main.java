package ru.maxima.anons.example2;

import java.util.Arrays;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        int elements[] = {2, 2, 1, 5, 6, 10, 11};

        Sequence sequence = new Sequence(elements) {

            @Override
            public void sort() {
                int min;
                int indexOfMin;
                int temp;

                for (int i = 0; i < array.length; i++) {
                    min = array[i];
                    indexOfMin = i;

                    for (int j = i; j < array.length; j++) {
                        if (array[j] < min) {
                            min = array[j];
                            indexOfMin = j;
                        }
                    }

                    temp = array[i];
                    array[i] = min;
                    array[indexOfMin] = temp;
                }
            }

            @Override
            public boolean search(int element) {
                int left;
                int right;
                int middle;

                left = 0;
                right = array.length - 1;
                middle = left + (right - left) / 2;

                boolean isExists = false;

                while (left <= right) {
                    if (array[middle] < element) {
                        left = middle + 1;
                        middle = left + (right - left) / 2;
                    } else if (array[middle] > element) {
                        right = middle - 1;
                        middle = left + (right - left) / 2;
                    } else if (array[middle] == element) {
                        isExists = true;
                        break;
                    }
                }

                return isExists;
            }
        };

        sequence.sort();
        System.out.println(sequence.search(10));

    }
}
