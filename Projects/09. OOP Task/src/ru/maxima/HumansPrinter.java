package ru.maxima;

/**
 * 16.06.2021
 * 09. OOP Task
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HumansPrinter {
    void print(Human[] humans) {
        System.out.printf("%20s|%10s|\n", "Имя", "Возраст");
        for (int i = 0; i < humans.length; i++) {
            System.out.printf("%20s|%10s|\n", humans[i].name, humans[i].getAge());
        }
    }

    void print(int ages[]) {
        System.out.printf("%20s лет|%25s|\n", "Возраст", "Сколько раз встречается?");
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] != 0) {
                System.out.printf("%24d|%25d|\n", i, ages[i]);
            }
        }
    }
}
