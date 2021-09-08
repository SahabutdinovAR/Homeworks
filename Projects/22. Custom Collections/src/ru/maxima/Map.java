package ru.maxima;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 *
 * Интерфейс, описывающий ассоциативный массив
 * Предполагается, что все ключи должны быть уникальными
 */
public interface Map {
    /**
     * Добавляет значение под каким либо ключом
     * @param key ключ
     * @param value значение
     */
    void put(Object key, Object value);

    /**
     * Получает значение по какому-либо ключу
     * @param key ключ
     * @return значение, которое было размещено под этим ключом
     */
    Object get(Object key);
    // данный интерфейс описывает пару ключ-значение
    interface MapEntry {
        Object key();
        Object value();
    }
    // возвращает множество ключей
    Set keySet();
    // возвращаем коллекцию всех значений, при этом не гарантируем порядок значений
    Collection values();
    // возвращает множество всех пар ключ-значение, ключи уникальные, значения могут быть в любом порядке
    Set entrySet();
    // проверяет, есть ли ключ в Map-е
    boolean containsKey(Object key);
    // проверят, есть ли значение в Map-е
    boolean containsValue(Object value);
}
