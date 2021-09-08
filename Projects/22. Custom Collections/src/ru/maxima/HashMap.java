package ru.maxima;

/**
 * 16.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HashMap implements Map {
    private static final int MAX_ARRAY_SIZE = 16;

    public static class MapEntry implements Map.MapEntry {
        Object key;
        Object value;
        MapEntry next;

        public MapEntry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object key() {
            return key;
        }

        @Override
        public Object value() {
            return value;
        }

        public MapEntry getNext() {
            return next;
        }

        public void setNext(MapEntry next) {
            this.next = next;
        }
    }

    private MapEntry entries[] = new MapEntry[MAX_ARRAY_SIZE];

    private int size = 0;

    @Override
    public void put(Object key, Object value) {
        // получили хеш-код
        int hash = key.hashCode();
        // нужно уменьшить его до размеров массива
        int index = hash & entries.length - 1; // 0 .. 15

        // сейчас мы имеем индекс, куда хотим положить элемент, но там уже может лежать какой-то другой элемент
        // мы просто его положим туда же, после того элемента, который уже лежит (или до)
        // если в этом бакете ничего нет, то просто кладем туда элемент
        if (entries[index] == null) {
            entries[index] = new MapEntry(key, value);
        } else {
            // если в бакете уже лежат элементы
            // у нас два случая:
            // 1. у них просто совпал хеш-код/индекс
            // 2. мы кладем новое значение под уже существующим ключом

            // берем первый элемент бакета
            MapEntry current = entries[index];

            // пока не просмотрим все элементы
            while (current != null) {
                // смотрим, не тот ли это ключ, который уже был?

                // сначала сравниваем хеш-коды, если они не совпадут, то понятное дело, это другой ключ
                // сравнение по хешам быстрее
                if (current.key.hashCode() == key.hashCode()) {
                    // если хеш-коды все-таки совпали, попробуем проверить по equals, разные ли это ключи?
                    if (current.key.equals(key)) {
                        // если они совпали по equals - то мы просто должны заменить значение, такой ключ уже был
                        current.value = value;
                        // останавливаем выполнение процедуры
                        return;
                    }
                    // если они не совпали по equals, то идем дальше
                }
                // если они не совпали по hashCode, то это разные ключи, идем дальше
                current = current.next;
            }
            // мы оказываемся здесь, если перебрали все ключи текущего бакета под index-ом
            // и не нашли такого же ключа
            // следовательно, нужно положить эту пару как новую в текуший бакет
            MapEntry newMapEntry = new MapEntry(key, value);
            // следующий после нового узла - это первый узел, который был в бакете
            newMapEntry.next = entries[index];
            // теперь новый узел - первый в текущем бакете
            entries[index] = newMapEntry;
        }

        size++;
    }

    @Override
    public Object get(Object key) {
        // TODO: реализовать
        return null;
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set entrySet() {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }
}
