package ru.maxima.example2;

/**
 * 22.07.2021
 * 25. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HashSet<T> implements Set<T> {

    private HashMap<T, Object> hashMap = new HashMap<>();

    private static final Object PRESENT = new Object();

    @Override
    public void add(T element) {
        hashMap.put(element, PRESENT);
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
    public boolean contains(T element) {
        return hashMap.containsKey(element);
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
