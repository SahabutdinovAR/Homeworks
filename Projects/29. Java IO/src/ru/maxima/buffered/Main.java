package ru.maxima.buffered;

import java.io.*;

/**
 * 03.08.2021
 * 29. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Reader in = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(in);
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {

        }

    }
}
