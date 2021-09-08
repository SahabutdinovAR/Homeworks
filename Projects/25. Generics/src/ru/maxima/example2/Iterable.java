package ru.maxima.example2;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 *
 * Показывает, что объект класса можно обойти итератором
 */
public interface Iterable<E> {
    /**
     * Возвращает итератор по набору данных
     * @return объект-итератор
     */
    // тут буква B подставляется в букву A у Iterator
    Iterator<E> iterator();
}
