package ru.maxima.example2;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 *
 * Бегунок, который последовательно может обходить какой-либо набор данных
 */
public interface Iterator<E> {
    /**
     * Проверяет, есть ли следующий элемент
     * @return <code>true</code>, если элементы еще есть, <code>false</code> в противном случае
     */
    boolean hasNext();

    /**
     * Возвращает следующий элемент и переводит курсор дальше
     * @return следующий на очереди элемент
     */
    E next();
}
