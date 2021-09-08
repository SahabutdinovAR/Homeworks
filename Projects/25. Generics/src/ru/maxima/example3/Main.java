package ru.maxima.example3;

import ru.maxima.example2.ArrayList;
import ru.maxima.example2.List;

/**
 * 20.07.2021
 * 25. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(155);
        integers.add(158);

        int value = integers.get(0);
//        list.add("Стринг");

        List<Character> characters = new ArrayList<>();
//        characters.add(123);
        characters.add('A');
        characters.add('B');
        characters.add('C');

        List<Boolean> booleans = new ArrayList<>();
        booleans.add(true);
        booleans.add(false);
//        booleans.add("Привет");

        // как это работает?

        // очевидно, что любой объект любого типа можно преобразовать в Object
//        Integer i = new Integer(10);
//        Object integerAsObject = i;

        // как из 155 автоматически получается объект типа Integer? и наоборот

        Integer i = new Integer(10); // упаковка (boxing), получаете объект Integer в котором лежит 10
        Integer i1 = 10; // автоупаковка (autoboxing)

        int valueFromInteger = i1.intValue(); // распаковка (unboxing)
        int valueFromInteger2 = i1; // автораспаковка (autounboxing)
    }
}
