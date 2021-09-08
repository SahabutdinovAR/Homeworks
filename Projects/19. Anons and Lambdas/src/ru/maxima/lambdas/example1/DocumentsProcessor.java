package ru.maxima.lambdas.example1;

import ru.maxima.anons.example1.Document;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsProcessor {
    // сколько документов мы можем хранить
    private static final int MAX_PROCESSED_DOCUMENTS_COUNT = 10;
    // массив для хранения обработанных документов
    private Document[] documents;
    private int count;

    public DocumentsProcessor() {
        this.documents = new Document[MAX_PROCESSED_DOCUMENTS_COUNT];
        this.count = 0;
    }

    public void printDocuments() {
        for (int i = 0; i < count; i++) {
            System.out.println("Документ - " + documents[i].getValue());
        }
    }

    public void process(Document document, ProcessingLogic processingLogic) {
        if (isHasSize()) {
            Document processed = processingLogic.process(document);
            save(processed);
        } else {
            System.err.println("Кончилось место для обработки документов");
        }
    }

    private void save(Document document) {
        documents[count] = document;
        count++;
    }

    private boolean isHasSize() {
        return count < MAX_PROCESSED_DOCUMENTS_COUNT;
    }
}
