package ru.maxima.reader_writer;

import java.io.*;

/**
 * 03.08.2021
 * 29. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainReader {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Reader reader = new FileReader(file);
            char[] values = new char[100];
            reader.read(values);
            String string = new String(values);
            System.out.println(string);
        } catch (FileNotFoundException e) {
            System.err.println("Проблемы с вводом/выводом - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Проблемы");
        }
    }
}
