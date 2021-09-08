package ru.maxima.example2;

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
public interface Map<K, V> {
    /**
     * Добавляет значение под каким либо ключом
     * @param key ключ
     * @param value значение
     */
    void put(K key, V value);

    /**
     * Получает значение по какому-либо ключу
     * @param key ключ
     * @return значение, которое было размещено под этим ключом
     */
    V get(K key);
    // данный интерфейс описывает пару ключ-значение
    interface MapEntry<K, V> {
        K key();
        V value();
    }
    // возвращает множество ключей
    Set<K> keySet();
    // возвращаем коллекцию всех значений, при этом не гарантируем порядок значений
    Collection<V> values();
    // возвращает множество всех пар ключ-значение, ключи уникальные, значения могут быть в любом порядке
    Set<MapEntry<K,V>> entrySet();
    // проверяет, есть ли ключ в Map-е
    boolean containsKey(K key);
    // проверят, есть ли значение в Map-е
    boolean containsValue(V value);
}
