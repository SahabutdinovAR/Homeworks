package ru.maxima;

/**
 * 08.07.2021
 * 22. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LinkedList implements List {

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
    // ссылка на первый элемент
    private Node first;
    // ссылка на последний элемент
    private Node last;

    private int size;

    @Override
    public Object get(int index) {
        if (indexInBounds(index)) {
            // начинаем с первого узла
            Node current = first;
            for (int i = 0; i < index; i++) {
                // сдвигаем current на нужную позицию
                current = current.next;
            }
            return current.value;
        }
        return null;
    }

    @Override
    public int indexOf(Object element) {
        // TODO: реализовать
        return 0;
    }

    @Override
    public int lastIndexOf(Object element) {
        // TODO: реализовать
        return 0;
    }

//    @Override
//    public void add(Object element) {
//        // создали новый узел
//        Node newNode = new Node(element);
//        // если список пустой
//        if (isEmpty()) {
//            // то первый элемент списка - это добавляемый элемент
//            first = newNode;
//        } else {
//            // в противном случае нужно дойти до последнего элемента, и новый поставить после него
//            Node current = first;
//            // пока не дошли до элемента, после которого ничего нет
//            while (current.next != null) {
//                // идем дальше
//                current = current.next;
//            }
//            // мы вышли из цикла, и теперь мы на последнем элементе
//            // теперь следующий после последнего - это новый элемент
//            current.next = newNode;
//        }
//        size++;
//    }

    @Override
    public void add(Object element) {
        // создали узел
        Node newNode = new Node(element);
        // если список пустой
        if (isEmpty()) {
            // начало и конец - это единственный узел
            last = newNode;
            first = newNode;
        } else {
            // следующий элемент после последнего - новый узел
            last.next = newNode;
            // теперь новый узел является последним
            last = newNode;
        }
        size++;
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

    @Override
    public Iterator iterator() {
        // TODO: реализовать
        return null;
    }

    private boolean indexInBounds(int index) {
        return index >= 0 && index < size;
    }
}
