package ru.maxima;

/**
 * 10.08.2021
 * 30. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NumbersUtil {
    // 2, 3, 7, 11, 13, 23, ... 31
    // алгоритм 1:
    // берем число и перебираем все числа от 2 до (number - 1)
    // делим number на эти числа, пока не найдем делитель
    // 11 -> 2, 3, 4, 5, 6, 7, 8, 9, 10
    // 113 -> 2, 3, 4, 5, 6, 7, 8, 9, ..., 110, 111, 112
    // алгоритм 2:
    // берем число и перебираем все числа от 2 до number/2
    // делим number на эти числа, пока не найдем делитель
    // 11 -> 2, 3, 4, 5
    // 113 -> 2, 3, 4, 5, ... 56
    // алгоритм 3:
    // берем число и перебираем все числа от 2 до корня из number
    // делим number на эти числа, пока не найдем делитель
    // 11 -> 2, 3
    // 113 -> 2, 3, 4, 5, 6, 7, 8, 9, 10
    // i < sqrt(number) -> i * i < sqrt(number) * sqrt(number) -> i^2 < number
    public boolean isPrime(int number) {

        if (number == 0 || number == 1) {
            throw new IllegalArgumentException();
        }

        if (number == 2 || number == 3) {
            return true;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     * Преобразует строку в число
     * @param number строка формата 123, -123, -123.3 -> -123
     * @return целочисленное представление
     * @throws IllegalArgumentException для строк любого другого вида
     */
    public int parse(String number) {
        return -1;
    }

}
