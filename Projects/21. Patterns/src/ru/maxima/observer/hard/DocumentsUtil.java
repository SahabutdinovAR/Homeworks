package ru.maxima.observer.hard;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// Observable
public interface DocumentsUtil {
    /**
     * Метод для добавления документа на обработку
     * @param document текст документа
     */
    void addDocument(String document);

    /**
     * Метод для добавления обработчиков событий, связанных с добавлением документов
     * @param processor обработчик
     */
    void addProcessor(DocumentProcessor processor);

    /**
     * Оповестить обработчиков о возникновении документа
     * @param document текст документа
     */
    void notifyProcessors(String document);
}
