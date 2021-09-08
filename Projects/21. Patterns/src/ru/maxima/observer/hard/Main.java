package ru.maxima.observer.hard;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
        Scanner scanner = new Scanner(System.in);

        DocumentsUtil documentsUtil = new DocumentsUtilImpl();

        documentsUtil.addProcessor(new CertificateProcessor());
        documentsUtil.addProcessor(new StatementsProcessor());
        documentsUtil.addProcessor(document -> System.err.println("Документ <" + document +
                "> был получен в " + LocalTime.now()));

        while (true) {
            String document = scanner.nextLine();
            documentsUtil.addDocument(document);
        }
    }
}
