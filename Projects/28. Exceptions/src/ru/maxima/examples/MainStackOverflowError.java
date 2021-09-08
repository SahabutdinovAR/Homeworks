package ru.maxima.examples;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStackOverflowError {

    // 4! = 1 * 2 * 3 * 4 = 24
    // 5! = 1 * 2 * 3 * 4 * 5 = 120
    // n! = 1 * 2 * ... * n
    // 5! = 1 * 2 * 3 * 4 * 5 = 4! * 5
    // n! = (n - 1)! * n

    // рекурсия, функция вызывает саму себя, до тех пор, пока n не будет равен 0, тогда вернется 1 и все закончится
    private static int f(int n) {
//        if (n == 0) {
//            return 1;
//        }
        return f(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
