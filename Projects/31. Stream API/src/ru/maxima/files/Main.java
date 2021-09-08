package ru.maxima.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 14.08.2021
 * 31. Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            reader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
