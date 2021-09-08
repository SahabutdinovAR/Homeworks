package ru.maxima.try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main_1 {

    public static int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];
        int i = 0;
        while (true) {

            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int result = div(a, b);
                System.out.println(result);
                array[i] = result;
                i++;
            } catch (ArithmeticException e) {
                System.out.println("У вас ошибка - " + e.getMessage());
                System.out.println("Введите данные заново!");
            } catch (InputMismatchException e) {
                System.out.println("Вы неверно ввели данные...");
                System.out.println("Введите данные заново!");
                scanner.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Массив переполнен");
            }
        }
    }
}
