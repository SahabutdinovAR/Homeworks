package ru.maxima.lambdas.example1;

import ru.maxima.anons.example1.Document;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// функциональный интерфейс - потому что в нем один единственный метод
public interface ProcessingLogic {
    Document process(Document document);
}
