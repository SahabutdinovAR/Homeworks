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
public class MainInputStream3 {
    public static void main(String[] args) {
        byte b = (byte) 255;
        System.out.println(b);
        File file = new File("input.txt");

        try {
            // открыли байтовый поток для чтения
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            int bytesCount = inputStream.read(bytes, 1, 2);
            System.out.println(bytesCount);
            System.out.println(Arrays.toString(bytes));
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка ввода/вывода - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода" + e.getMessage());
        }
    }
}
