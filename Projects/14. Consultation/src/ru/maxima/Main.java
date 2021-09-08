package ru.maxima;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // пусть пользователь вводит числа
        // я эти числа запоминаю в массив
        // далее, я должен вывести статистику по этим числам - минимальное, максимальное, среднее
        Scanner scanner = new Scanner(System.in);

        FileManager fileManager = new FileManager("Марсель");

        int filesCount = scanner.nextInt();
        scanner.nextLine();

        int i = 0;
        while (i < filesCount) {
            String fileName = scanner.nextLine();
            long size = scanner.nextLong();
            scanner.nextLine();

            fileManager.addFile(fileName, size);

            i++;
        }

        System.out.println("MIN - " + fileManager.minSize());

        String h1 = "Марсель";
    }
}
