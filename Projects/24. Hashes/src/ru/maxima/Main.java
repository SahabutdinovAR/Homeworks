package ru.maxima;

import java.util.Arrays;

public class Main {

    public static int myHashCode(String string) {
        // получить массив символов этой строки
        char[] array = string.toCharArray();
        int[] asInt = new int[array.length];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            asInt[i] = array[i];
            result += array[i];
        }
        System.out.println(Arrays.toString(asInt));
        return result;
    }

    public static int stringHashCode(String string) {

        char val[] = string.toCharArray();
        int h = 0;
        for (int i = 0; i < val.length; i++) {
            h = 31 * h + val[i];
        }
        return h;
    }
    // h  = 0
    // 0) h = 31 * 0 + 72
    // 1) h = 31 * (31 * 0 + 72) + 101
    // 2) h = 31 * (31 * (31 * 0 + 72) + 101) + 108
    // 3) h = 31 * (31 * (31 * (31 * 0 + 72) + 101) + 108) + 108
    // 4) h = 31 * (31 * (31 * (31 * (31 * 0 + 72) + 101) + 108) + 108) + 111
    // 5) h = 31 * (31 * (31 * (31 * (31 * (31 * 0 + 72) + 101) + 108) + 108) + 111) + 33
    // Распишем формулу:
    // 31 * (31 * (31 * (31 * (31 * (31 * 0 + 72) + 101) + 108) + 108) + 111) + 33 =
    // 31 * 31 * 31 * 31 * 31 * 72 + 31 * 31 * 31 * 31 * 101 + 31 * 31 * 31 * 108 + 31 * 31 * 108 + 31 * 111 + 33 =
    // hash = 72 * 31^5 + 101 * 31^4 + 108 * 31^3 + 108 * 31^2 + 111 * 31^1 + 33 * 31^0
    // hash = sum val[i] * 31^(n - 1 - i)
    // n - длина строки
    // Хеш-код строки, это сумма символов букв строки, при этом каждый код умножается на число 31 в степени,
    // равной обратной позиции символа.
    // 1) Сумма кодов - очевидно
    // 2) используется позиция символа как степень - чтобы от перестановки букв менялся хеш-код
    // 3) почему 31 -> простое число, т.е. его нельзя разложить на множители. Поэтому можно перемножать 31 между собой
    // и породить минимум коллизий.
    // если например использовать 20, 20 * k * 20 * u * 20 * t -> 2 * 10 -> 2 * 5 * 2 и т.д.

    public static void main(String[] args) {
        String string = "Hello!"; // [72, 101, 108, 108, 111, 33]
        String string1 = "!olleH";

        System.out.println(stringHashCode(string));
        System.out.println(stringHashCode(string1));

        int i = 432213;
        char c = 'A';
        double d = 7.8;
        boolean b = true;
        System.out.println("FOR PRIMITIVE TYPES:");

        System.out.println(Integer.hashCode(i)); // хеш-код int это тот же самый int
        System.out.println(Character.hashCode(c)); // хеш-код char это код символа
        System.out.println(Double.hashCode(d)); // у double - битовое представление
        System.out.println(Boolean.hashCode(b));// у boolean - 1231 (true) 1237 (false);

        Human human = new Human("Марсель", "Сидиков", 27, true,1.85,  'M');
        Human human1 = new Human("Марсел", "Сидиков", 27, true,1.85,  'M');
        System.out.println(human.hashCode());
        System.out.println(human1.hashCode());

    }
}
