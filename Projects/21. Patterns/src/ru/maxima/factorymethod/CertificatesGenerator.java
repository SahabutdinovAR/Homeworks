package ru.maxima.factorymethod;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CertificatesGenerator implements DocumentsGenerator {
    @Override
    public Document generate(String text) {
        return new Certificate(" <" + text + "> от " + LocalDate.now(), text);
    }
}
