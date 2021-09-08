package ru.maxima.lambdas.example1.solution1;

import ru.maxima.anons.example1.Document;
import ru.maxima.lambdas.example1.ProcessingLogic;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AbbreviatedProcessingLogicImpl implements ProcessingLogic {
    @Override
    public Document process(Document document) {
        return new Document(document.getValue() % 1000);
    }
}
