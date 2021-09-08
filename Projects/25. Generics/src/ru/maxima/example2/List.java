package ru.maxima.example2;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 * <p>
 * Описывает интерфейс, для которого характерна упорядоченность элементов.
 * Т.е. если элемент был добавлен 3-им, то он и будет доступен под третьей позицией
 */
public interface List<T> extends Collection<T> {
    /**
     * Возвращает элемент под заданным индексом
     *
     * @param index индекс элемента
     * @return возвращаемый элемент
     */
    T get(int index);

    /**
     * Возвращает индекс элемента, если он есть в списке (первый, который встретили)
     *
     * @param element искомый элемент
     * @return индекс элемента, или <code>-1</code> если элемент не найден
     */
    int indexOf(T element);

    /**
     * Возвращает индекс элемента, если он есть в списке (последний, который встретили)
     *
     * @param element искомый элемент
     * @return индекс элемента, или <code>-1</code> если элемент не найден
     */
    int lastIndexOf(T element);
}
