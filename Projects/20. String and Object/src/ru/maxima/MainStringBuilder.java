package ru.maxima;

import java.util.Scanner;

/**
 * 02.07.2021
 * 20. String and Object
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // строка для хранения текста пользователя
        // строки незименяемые, поэтому каждый раз, когда вы склеиваете (+=) строки, выделяется память под новую строку
        // изменяется не старая строка, а создается новая

        // String text = "";

        StringBuilder text = new StringBuilder();
        while (true) {
            // считываем строку
            String line = scanner.nextLine();
            // если строка равна end
            if (line.equals("end")) {
                // завершаем бесконечный цикл
                break;
            } else {
                // если это просто строка
                // добавляем ее к тексту
                text
                        .append(line)
                        .append(" ");
            }
        }

        // выводим текст
        System.out.println(text.toString());
    }
}
