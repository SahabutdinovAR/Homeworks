package ru.maxima;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayList implements List {

    // начальный размер массива
    private static final int INITIAL_SIZE = 10;
    // ссылка на массив для хранения элементов
    private Object[] elements;
    // текущее количество элементов
    private int size;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        if (indexInBounds(index)) {
            return elements[index];
        }
        return null;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        // TODO: реализовать
        return 0;
    }

    @Override
    public void add(Object element) {
        // если количество элементов равно размеру массива
        if (isOverhead()) {
            // изменяем размер
            resize();
        }
        // добавляем элемент в первую пустую позицию
        elements[size] = element;
        size++;
    }

    private void resize() {
        // создаем новый массив, его размер - это размер предыдущего увеличенный в полтора раза
        Object[] newElements = new Object[elements.length + elements.length / 2];

        // копируем элементы из старого массива в новый
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        // затираем ссылку на старый массив ссылкой на новый массив, который в полтора раза больше
        this.elements = newElements;
    }

    private boolean isOverhead() {
        return size == elements.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object element) {
        // TODO: реализовать
        return false;
    }

    @Override
    public void remove(Object element) {
        // TODO: реализовать
    }

    private boolean indexInBounds(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    // внутренний класс, имеет доступ к полям объекта внешнего класса, например elements
    private class ArrayListIterator implements Iterator {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            // запоминаю текущий элемент
            Object result = elements[current];
            // двигаю курсор дальше
            current++;
            // возвращаю элемент, который я запомнил
            return result;
        }
    }
}