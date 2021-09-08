package ru.maxima.lambdas.example1.solution2;

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

//        ProcessingLogic abbreviatedProcessingLogic = new ProcessingLogic() {
//            @Override
//            public Document process(Document document) {
//                return new Document(document.getValue() % 1000);
//            }
//        };
        // лямда-выражение
        // анонимная реализация единственного метода функционального интерфейса
        ProcessingLogic abbreviatedProcessingLogic = document -> new Document(document.getValue() % 1000);

        ProcessingLogic removeUnnecessaryProcessingLogic = document -> {
            // удаляем нули из числа
            int value = document.getValue();
            int newValue = 0;

            while (value != 0) {
                int digit = value % 10;
                if (digit != 0) {
                    newValue = newValue + digit;
                    newValue = newValue * 10;
                }
                value = value / 10;
            }

            return new Document(newValue / 10);
        };

        Document d1 = new Document(134000232);
        Document d2 = new Document(234312490);
        Document d3 = new Document(78273823);
        Document d4 = new Document(43878100);
        Document d5 = new Document(1232198);
        Document d6 = new Document(34238989);

        processor.process(d1, abbreviatedProcessingLogic);
        processor.process(d2, abbreviatedProcessingLogic);
        processor.process(d3, document -> new Document(document.getValue() % 10));
        processor.process(d4, removeUnnecessaryProcessingLogic);
        processor.process(d5, removeUnnecessaryProcessingLogic);
        processor.process(d6, removeUnnecessaryProcessingLogic);

        processor.printDocuments();

    }
}
