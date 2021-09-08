package ru.maxima;

import ru.maxima.bads.BadSet;

public class Main {

    public static void main(String[] args) {
        Map map = new HashMap();

        // a[3] = 6, 3 - ключ, 6 - значение
        map.put("Сидиков", "Марсель");
        map.put("Поздеев", "Максим"); // OK
        map.put("Вдовинов", "Даниил"); // OK
        map.put("Евлампьев", "Виктор"); // OK
        map.put("Мухутдинов", "Айрат"); // OK
        map.put("Мухутдинова", "Алия"); // OK
        map.put("Набиев", "Азат"); // OK
        map.put("Миниахметов", "Разиль"); // OK
        map.put("Хафизов", "Тимур"); // OK
        map.put("Пашаев", "Эмиль"); // OK
        map.put("Батршин", "Тимур"); // OK
        map.put("Беспалов", "Вадим"); // OK
        map.put("Сабирзянова", "Аделя"); // OK
        map.put("Хасанов", "Ильгам"); // OK
        map.put("Забиров", "Салават"); // OK
        map.put("Путин", "Владимир"); // OK
        map.put("Медведев", "Дмитрий"); // OK
        map.put("Метшин", "Ильсур"); // OK
        map.put("Сидиков", "Рафаэль"); // OK

        // System.out.println(a[3]); - выведет 6
        System.out.println(map.get("Поздеев")); // Максим
        System.out.println(map.get("Сидиков")); // Рафаэль

        Set set = new BadSet();
        set.add("Привет");
        set.add("Как дела");
        set.add("Привет");
        set.add("Что нового");
        set.add("Как дела");

        System.out.println(set.contains("Привет"));
        System.out.println(set.contains("Как дела"));
        System.out.println(set.contains("Что нового"));
        System.out.println(set.contains("Пока"));

        Set keys = map.keySet(); // keys -> Поздеев, Евлампьев, Сидиков, Вдовинов
        Collection values = map.values(); // values -> Даниил, Рафаэль, Виктор, Максим
        Set entries = map.entrySet(); // entries -> <Даниил, Вдовинов>, <Виктор, Евламплев> ...
    }
}
