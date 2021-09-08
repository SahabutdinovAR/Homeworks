package ru.maxima.bads;

import ru.maxima.Collection;
import ru.maxima.Map;
import ru.maxima.Set;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BadMap implements Map {

    private static final int MAX_ARRAY_SIZE = 10;

    public static class BadMapEntry implements Map.MapEntry {
        Object key;
        Object value;

        public BadMapEntry(Object key, Object value) {
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
    }

    private BadMapEntry entries[];
    private int size;

    public BadMap() {
        this.entries = new BadMapEntry[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(Object key, Object value) {
        for (int i = 0; i < size; i++) {
            // если уже есть значение с таким ключом
            if (entries[i].key.equals(key)) {
                // заменяем это значение
                entries[i].value = value;
                return;
            }
        }
        entries[size] = new BadMapEntry(key, value);
        size++;
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public Set keySet() {
        // TODO: реализовать
        return null;
    }

    @Override
    public Collection values() {
        // TODO: реализовать
        return null;
    }

    @Override
    public Set entrySet() {
        // TODO: реализовать
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO: реализовать
        return false;
    }
}
