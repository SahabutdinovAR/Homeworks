* `Iterator<E>`

```java
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
```

* `Iterable<E>`

```java
public interface Iterable<T> {
    Iterator<T> iterator();
}
```

* `Collection<E>`

```java
public interface Collection<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    // из Iterable
    Iterator<E> iterator();
    
    Object[] toArray();
    <T> T[] toArray(T[] a);
    
    boolean add(E e);
    boolean remove(Object o);
    
    void clear();
    // пришли автоматически из Object
    int hashCode();
    boolean equals(Object o);
}
```

* `List<E>`

```java
public interface List<E> extends Collection<E> {
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
}
```

* `ArrayList<E>`

```java
public class ArrayList<E> implements List<E> {
    // размер массива по умолчанию
    private static final int DEFAULT_CAPACITY = 10;
    // массив, который хранит элементы списка
    Object[] elementData; 
    
    // количество элементов в списке
    private int size;
    
    public boolean add(E e) {
        // добавляем новый элемент, значит нужно убедиться, что в массиве есть место для нового элемента
        ensureCapacityInternal(size + 1);
        // просто добавляем элемент
        elementData[size++] = e;
        return true;
    }
    // обеспечивает необходимый объем массива для требуемого количества данных
    private void ensureCapacityInternal(int minCapacity) {
        // получаем число, которое равно minCapacity, или 10 - если minCapacity меньше десяти
        int capacity = calculateCapacity(elementData, minCapacity);
        // функция выделения памяти, если необходимо
        ensureExplicitCapacity(capacity);
    }
    
    // она для массива elementData определяет, какой объем нужен этому массиву, чтобы обеспечить вместимость minCapacity-элементов
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // если elementData ничего не содержит, он абсолютно пустой
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // возвращаем максимальное число из 10 и требуемой вместимости. Т.е. если требуется обеспечить объем в 5 единиц, то он вернет 10
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // в противном случае, будет возвращено необходимо количество
        return minCapacity;
    }
    // проверяет, необходимо ли увеличивать массив, и увеличивает если нужно
    private void ensureExplicitCapacity(int minCapacity) {
    // если требуемый объем массива оказался больше, чем есть сейчас по факту
    if (minCapacity - elementData.length > 0)
        // увеличиваем размер массива
        grow(minCapacity);
    }
    
    private void grow(int minCapacity) {
        // запоминаем старый размер массива
        int oldCapacity = elementData.length;
        // вычисляем новый размер массива, оператор a >> n, означает что биты числа a будут сдвинуты вправо на n единиц
        // в данном случае, мы сдвигаем биты у старого размера. Этот оператор означает то же самое, что и a / 2^n, т.е. делим на степень двойки
        // только операция выполняется быстрее
        // в итоге новый размер будет равен - старый размер + 50 от старого, увеличили в полтора раза
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // если новый размер оказался меньше, чем требуемый
        if (newCapacity - minCapacity < 0)
            // то новый размер равен требуемому
            newCapacity = minCapacity;
        // если размер больше, чем максимально возможный
        if (newCapacity - MAX_ARRAY_SIZE > 0)
           // оставляем максимальный размер
           newCapacity = hugeCapacity(minCapacity);
           // создаем новый массив и копируем в него данные
           // вызывается нативная функция System.arraycopy (выполняется очень быстро)
           elementData = Arrays.copyOf(elementData, newCapacity);
        }
}
```

* `LinkedList<E>`

```java
public class LinkedList<E> implements List<E>, Deque<E>{
    int size = 0; // размер списка
    
    Node<E> first; // первый узел списка
    Node<E> last; // последний узел списка
    
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
    }
    
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
    
     Node<E> node(int index) {
        // >> побитовый сдвиг влево, т.е. n >> x, то биты числа n будут сдвинуты направо на x шагов. 
        // Это равносильно делению числа на степень двойки
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    
    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    
    void linkLast(E e) {
        // запоминаем последний узел в l
        final Node<E> l = last;
        // создаем новый узел, у которого в качестве предыдущего указал l
        final Node<E> newNode = new Node<>(l, e, null);
        // теперь новый узел - последний
        last = newNode;
        // если последнего узла не было (т.е. список пустой)
        if (l == null)
            // то новый узел также является первым
            first = newNode;
        else
            // если в списке что-то было, то последний элемент в качестве следующего содержит новый узел
            l.next = newNode;
        size++;
    }
}
```

* `Queue<E>`

```java
public interface Queue<E> extends Collection<E> {
    // добавляет элемент в очередь
    boolean add(E e);
    // забирает элемент из "головы" очереди
    E pool();
    // смотрит элемент, который содержится в "голове" очереди без его удаления
}
```

* `Stack<E>` - устаревший класс, не используем.

* Вместо `Queue<E>` и `Stack<E>` лучше использовать двустороннюю очередь `Deque<E>`

```java
public interface Deque<E> extends Queue<E> {
    // добавляет элемент в голову Stack-а
    void push(E e);
    // получает элемент из стека
    E pop();
}
```

* `Set<E>`

```java
public interface Set<E> extends Collection<E> {
    // содержится ли элемент во множестве
    boolean contains(Object o);
    // добавляет во множество
    boolean add(E e);
}
```

* `HashSet<E>`

```java
public class HashSet<E> implements Set<E> {
    // HashMap гарантирует уникальность ключей
    private transient HashMap<E,Object> map;
    
    private static final Object PRESENT = new Object();
    
    public boolean add(E e) {
        // при добавлении значения в Set оно добавляется в качестве ключа в map-у с пустым значением PRESENT
        return map.put(e, PRESENT)==null;
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }
}
```

* `Map<E>`

```java
public interface Map<K,V> {
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);
    V put(K key, V value);
    V remove(Object key);
    Set<K> keySet();
    Collection<V> values();
    Set<Map.Entry<K, V>> entrySet();
    
    interface Entry<K,V> {    
        K getKey();
        V getValue();
    }
}
```

* `HashMap<E>`

```java
public class HashMap<K,V> implements Map<K,V> {
    // количество бакетов
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    
    static class Node<K,V> implements Map.Entry<K,V> {  
        // хеш ключа
        final int hash;
        // сам ключ
        final K key;
        // значение
        V value;
        // указатель на следующий элемент бакета
        Node<K,V> next;
    }
    // для ключа, перед добавлением пары <ключ-значение> вызывается метод hash()
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
    
    // встроенный метод "дохеширования"
    static final int hash(Object key) {
        if (key == null) {
            return 0;
        }
        // получаем хешкод ключа
        int hashCode = key.hashCode();
        // сдвигаю хеш-код на 16 бит вправо, левая часть заменяется на нули
        int shiftedHashCode = hashCode >>> 16; 
        // выполняю xor-операцию между хеш-кодом и сдвигом хеш-кода
        int result = hashCode ^ shiftedHashCode;
    }
}
```

## Операции по улучшению хеш-кода

1. Сделать сдвиг вправо

```
11010100001010111010011011101001 >>> 16 = 00000000000000001101010000101011
```

2. Делаю сложение по модулю

```
0 + 0 = 0
1 + 0 = 1
0 + 1 = 1
1 + 1 = 0
```

```
11010100001010111010011011101001
00000000000000001101010000101011
--------------------------------
11010100001010110111001011100010
```

Для чего это нужно? 

1. Если у ключа плохо определен hashCode (а именно - отличается слабо в последних битах), 
то с помощью операции сдвига мы смещаем "значимые" биты в конец, таким образом, хеш-коды станут разными.

2. С помощью операции ^ мы сохраняем влияние значимых битов в изначальном хешкоде.

* `HashMap` - изначально элементы распределяются по таблице, если элементов слишком много, и какой-то из бакетов переполняется, то 
этот бакет из списка превращается в красно-черное дерево. Если элементов в каждом бакете уже много, то мапа перестраивается на таблицу большего размера (16, 32, 64).