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
public class RemoveUnnecessaryProcessingLogicImpl implements ProcessingLogic {
    @Override
    public Document process(Document document) {
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
    }
}
