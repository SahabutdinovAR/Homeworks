package ru.maxima;

import java.util.HashMap;
import java.util.Map;

/**
 * 27.07.2021
 * 26. Java Collection API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Double.hashCode(0.06) >>> 16));
        Map<Double, String> map = new HashMap<>();
        // есть проблема - например у Double, хеш-код переопределен таким образом,
        // что последние биты очень часто повторяются
        // следовательно, все ключи попадают в один бакет, и равномерно-распределенная хеш-таблица
        // превращается в один нагруженный связный список, по которому нужно искать элементы
        map.put(0.01, "Марсель");
        map.put(0.02, "Айрат");
        map.put(0.03, "Максим");
        map.put(0.04, "Даниил");
        map.put(0.05, "Виктор");
        map.put(0.06, "Ильгам");
        map.put(0.07, "Алия");

        for (Double key : map.keySet()) {
            System.out.printf("%32s\n", Integer.toBinaryString(key.hashCode() ^ (key.hashCode() >>> 16)));
            System.out.printf("%32s\n", Integer.toBinaryString(key.hashCode()));
        }
    }
}
