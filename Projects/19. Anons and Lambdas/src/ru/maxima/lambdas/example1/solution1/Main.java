package ru.maxima.lambdas.example1.solution1;

import ru.maxima.anons.example1.Document;
import ru.maxima.lambdas.example1.DocumentsProcessor;
import ru.maxima.lambdas.example1.ProcessingLogic;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DocumentsProcessor processor = new DocumentsProcessor();

        ProcessingLogic abbreviatedProcessingLogic = new AbbreviatedProcessingLogicImpl();
        ProcessingLogic removeUnnecessaryProcessingLogic = new RemoveUnnecessaryProcessingLogicImpl();

        Document d1 = new Document(134000232);
        Document d2 = new Document(234312490);
        Document d3 = new Document(78273823);
        Document d4 = new Document(43878100);
        Document d5 = new Document(1232198);
        Document d6 = new Document(34238989);

        processor.process(d1, abbreviatedProcessingLogic);
        processor.process(d2, abbreviatedProcessingLogic);
        processor.process(d3, abbreviatedProcessingLogic);
        processor.process(d4, removeUnnecessaryProcessingLogic);
        processor.process(d5, removeUnnecessaryProcessingLogic);
        processor.process(d6, removeUnnecessaryProcessingLogic);

        processor.printDocuments();

    }
}
