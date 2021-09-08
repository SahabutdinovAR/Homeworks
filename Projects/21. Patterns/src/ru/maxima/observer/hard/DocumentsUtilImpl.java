package ru.maxima.observer.hard;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsUtilImpl implements DocumentsUtil {
    private static final int MAX_PROCESSORS_COUNT = 5;

    private DocumentProcessor[] processors;
    private int processorsCount = 0;

    public DocumentsUtilImpl() {
        this.processors = new DocumentProcessor[MAX_PROCESSORS_COUNT];
    }

    @Override
    public void addDocument(String document) {
        // TODO: тут может быть сложная логика по первоначальной обработке документа, например внесение в базу
        System.out.println("Получен документ - " + document);
        notifyProcessors(document);
    }

    @Override
    public void addProcessor(DocumentProcessor processor) {
        if (processorsCount < MAX_PROCESSORS_COUNT) {
            processors[processorsCount] = processor;
            processorsCount++;
        } else {
            System.err.println("Превышено максимальное количество обработчиков");
        }
    }

    @Override
    public void notifyProcessors(String document) {
        for (int i = 0; i < processorsCount; i++) {
            processors[i].handleDocument(document);
        }
    }
}
