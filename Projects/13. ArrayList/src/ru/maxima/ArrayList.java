package ru.maxima;

/**
 * 18.06.2021
 * 13. ArrayList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayList {
    // начальный размер массива
    private static final int INITIAL_SIZE = 10;
    // ссылка на массив для хранения элементов
    private int[] elements;
    // текущее количество элементов
    private int size;

    public ArrayList() {
        this.elements = new int[INITIAL_SIZE];
        this.size = 0;
    }
    /**
     * Добавляет элемент в конец списка
     * @param element добавляемый элемент
     */
    public void add(int element) {
        // если количество элементов равно размеру массива
        if (isOverhead()) {
            // создаем новый массив, его размер - это размер предыдущего увеличенный в полтора раза
            int[] newElements = new int[elements.length + elements.length / 2];

            // копируем элементы из старого массива в новый
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            // затираем ссылку на старый массив ссылкой на новый массив, который в полтора раза больше
            this.elements = newElements;
        }
        // добавляем элемент в первую пустую позицию
        elements[size] = element;
        size++;
    }

    private boolean isOverhead() {
        return size == elements.length;
    }

    /**
     * Возвращает элемент по его индексу (порядку добавления)
     * @param index индекс элемента
     * @return элемент
     */
    public int get(int index) {
        if (indexInBounds(index)) {
            return elements[index];
        }
        System.err.println("Index out of bounds");
        return -1;
    }

    /**
     * Добавляет элемент в начало списка, 6, 7, 8 -> addToBegin(9) -> 9 6 7 8
     * @param element
     */
    public void addToBegin(int element) {
        // TODO: реализовать
    }

    /**
     * Возвращает индекс искомого элемента (первый) 9, 6, 7, 6, 8 -> indexOf(6) -> 1
     * @param element искомый элемент
     * @return индекс
     */
    public int indexOf(int element) {
        // TODO: реализовать
        return -1;
    }

    /**
     * Возвращает индекс искомого элемента (последний) 9, 6, 7, 6, 8 -> lastIndexOf(6) -> 3
     * @param element искомый элемент
     * @return индекс
     */
    public int lastIndexOf(int element) {
        // TODO: реализовать
        return -1;
    }

    /**
     * Удаляет элемент в заданном индексе 9, 6, 7, 8, 9 -> remove(2) -> 9, 6, 8, 9
     * @param index индекс
     */
    public void remove(int index) {
        // TODO: реализовать
    }

    /**
     * Удаляет все вхождения элемента 9, 6, 7, 8, 9 -> removeAll(9) -> 6, 7, 8
     * @param element - удаляемый элемент
     */
    public void removeAll(int element) {
        // TODO: реализовать
    }


    private boolean indexInBounds(int index) {
        return index >= 0 && index < size;
    }

    public int size() {
        return size;
    }
}
