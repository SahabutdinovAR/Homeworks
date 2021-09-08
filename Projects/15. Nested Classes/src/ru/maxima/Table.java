package ru.maxima;

/**
 * 22.06.2021
 * 15. Nested Classes
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// Table - внешний класс
public class Table {
    // статически вложенный класс (вложенный класс)
    public static class TableEntry {
        private String key;
        private int value;

        public TableEntry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    // внутренний класс (нестатический)
    // он имеет доступ к полям внешнего класса
    public class Iterator {

        private int current = 0;
        // возвращает очередной элемент таблицы
        public TableEntry next() {
            // получаем очередной элемент таблицы
            TableEntry entry = entries[current];
            // двигаемся дальше
            current++;
            // возвращаем результат
            return entry;
        }

        // есть ли следующий элемент таблицы
        public boolean hasNext() {
            return current < count;
        }
    }

    private static final int MAX_ENTRIES_COUNT = 10;

    private TableEntry entries[];
    private int count;

    public Table() {
        this.entries = new TableEntry[MAX_ENTRIES_COUNT];
        this.count = 0;
    }

    public void put(String key, int value) {
        entries[count] = new TableEntry(key, value);
        count++;
    }

    public int get(String key) {
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }
        return -1;
    }
}
