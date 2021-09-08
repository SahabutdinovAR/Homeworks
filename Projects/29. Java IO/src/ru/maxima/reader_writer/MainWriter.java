package ru.maxima.reader_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 03.08.2021
 * 29. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainWriter {
    public static void main(String[] args) {
        File file = new File("output.txt");
        try {
            Writer writer = new FileWriter(file);
            writer.write("Привет");
            writer.close();
        } catch (IOException e) {
            System.err.println("Файл не найден");
        }
    }
}
