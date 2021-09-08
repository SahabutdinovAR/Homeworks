package ru.maxima.input_stream;

import java.io.*;
import java.util.Arrays;

/**
 * 03.08.2021
 * 29. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainInputStream2 {
    public static void main(String[] args) {
        File file = new File("input.txt");

        try {
            // открыли байтовый поток для чтения
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            // считываем первый байт из файла
            int currentByte = inputStream.read();
            int i = 0;
            // пока байт не равен -1
            while (currentByte != -1) {
                // кладем его в массив считанных байтов
                bytes[i] = (byte)currentByte;
                // считываем следующий байт
                currentByte = inputStream.read();
                i++;
            }
            System.out.println(Arrays.toString(bytes));
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка ввода/вывода - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода" + e.getMessage());
        }
    }
}
