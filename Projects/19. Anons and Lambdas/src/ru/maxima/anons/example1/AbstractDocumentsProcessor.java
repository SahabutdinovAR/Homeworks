package ru.maxima.anons.example1;

/**
 * 29.06.2021
 * 19. Anons and Lambdas
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class AbstractDocumentsProcessor {
    // сколько документов мы можем хранить
    private static final int MAX_PROCESSED_DOCUMENTS_COUNT = 10;
    // массив для хранения обработанных документов
    private Document[] documents;
    private int count;

    public AbstractDocumentsProcessor() {
        this.documents = new Document[MAX_PROCESSED_DOCUMENTS_COUNT];
        this.count = 0;
    }

    public void printDocuments() {
        for (int i = 0; i < count; i++) {
            System.out.println("Документ - " + documents[i].getValue());
        }
    }

    public void process(Document document) {
        if (isHasSize()) {
            Document processed = processingLogic(document);
            save(processed);
        } else {
            System.err.println("Кончилось место для обработки документов");
        }
    }

    // абстрактный метод, который должен содержать логику обработки документа
    public abstract Document processingLogic(Document document);

    private void save(Document document) {
        documents[count] = document;
        count++;
    }

    private boolean isHasSize() {
        return count < MAX_PROCESSED_DOCUMENTS_COUNT;
    }
}
