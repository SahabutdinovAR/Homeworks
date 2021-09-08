package ru.maxima.input_stream;

import java.io.*;

/**
 * 03.08.2021
 * 29. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainInputStream1 {
    public static void main(String[] args) {
        File file = new File("input.txt");

        try {
            // открыли байтовый поток для чтения
            InputStream inputStream = new FileInputStream(file);
            System.out.println(inputStream.available());
            int byte1 = inputStream.read();
            int byte2 = inputStream.read();
            int byte3 = inputStream.read();
            int byte4 = inputStream.read();
            int byte5 = inputStream.read();

            System.out.println((char)byte1 + " " + (char)byte2 + " " + (char)byte3 + " " + (char)byte4 + " " + (char)byte5);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка ввода/вывода - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода" + e.getMessage());
        }
    }
}
