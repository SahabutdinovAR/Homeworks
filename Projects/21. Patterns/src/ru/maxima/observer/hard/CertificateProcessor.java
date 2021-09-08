package ru.maxima.observer.hard;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CertificateProcessor implements DocumentProcessor {

    @Override
    public void handleDocument(String document) {
        if (document.contains("Справка")) {
            System.out.println("Обнаружена справка, отправлена на печать.");
        }
    }
}
