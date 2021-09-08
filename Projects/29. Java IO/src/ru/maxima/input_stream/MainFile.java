package ru.maxima.input_stream;

import java.io.File;
import java.io.FileNotFoundException;

public class MainFile {

    public static void throwException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void main(String[] args) {
        // получаете информацию о файле
	    File file = new File("input.txt");
        System.out.println(file.exists());
    }
}
