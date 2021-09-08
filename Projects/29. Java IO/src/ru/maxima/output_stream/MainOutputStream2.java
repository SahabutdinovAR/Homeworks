package ru.maxima.output_stream;

import java.io.*;

/**
 * 03.08.2021
 * 29. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainOutputStream2 {
    public static void main(String[] args) {
        File file = new File("output.txt");
        try {
            OutputStream outputStream = new FileOutputStream(file, true);
            String text = "Hello, how are you?";
            byte[] bytes = text.getBytes();
            outputStream.write(bytes);
            // чтобы записать данные в файл, необходимо закрыть поток
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка работы с вводом/выводом - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка работы с вводом/выводом");
        }
    }
}
