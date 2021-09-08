package ru.maxima.bads;

import ru.maxima.Iterator;
import ru.maxima.Map;
import ru.maxima.Set;
import ru.maxima.bads.BadMap;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BadSet implements Set {

    private Map map = new BadMap();

    private static final Object PRESENT = new Object();

    @Override
    public void add(Object element) {
        map.put(element, PRESENT);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object element) {
        return map.containsKey(element);
    }

    @Override
    public void remove(Object element) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
