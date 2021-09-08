package ru.maxima.factorymethod;

import java.util.Scanner;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DocumentsPrinter printer = new DocumentsPrinter();

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - если нужна справка");
        System.out.println("1 - если нужно заявление");

        int type = scanner.nextInt();
        scanner.nextLine();

        if (type == 1) {
            printer.setDocumentsGenerator(new CertificatesGenerator());
        } else {
            printer.setDocumentsGenerator(new StatementsGenerator());
        }

        String text = scanner.nextLine();
        printer.printDocument(text);
    }
}
