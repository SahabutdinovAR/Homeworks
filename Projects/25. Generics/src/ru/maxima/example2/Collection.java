package ru.maxima.example2;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 *
 * Описывает коллекцию, представляющую из себя набор элементов
 */
public interface Collection<T> extends Iterable<T> {
    /**
     * Добавляет элемент в коллекцию
     * @param element добавляемый элемент
     */
    void add(T element);

    /**
     * Возвращает количество элементов в коллекции
     * @return целое число, равное количеству элементов
     */
    int size();

    /**
     * Проверяет, не является ли коллекция пустой
     * @return <code>true</code>, если в коллекции нет элементов, <code>false</code> в противном случае
     */
    boolean isEmpty();

    /**
     * Проверяет, содержит ли коллекция какой-либо элемент
     * @param element искомый элемент
     * @return <code>true</code> если элемент найден, <code>false</code> в противном случае
     */
    boolean contains(T element);

    /**
     * Удаляет указанный элемент
     * @param element удаляемый элемент
     */
    void remove(T element);


}
