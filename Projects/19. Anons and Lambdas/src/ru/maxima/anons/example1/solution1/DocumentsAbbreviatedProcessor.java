package ru.maxima.anons.example1.solution1;

import ru.maxima.anons.example1.AbstractDocumentsProcessor;
import ru.maxima.anons.example1.Document;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsAbbreviatedProcessor extends AbstractDocumentsProcessor {

    @Override
    public Document processingLogic(Document document) {
        return new Document(document.getValue() % 1000);
    }
}
