package ru.maxima;

import java.util.HashSet;
import java.util.Set;

/**
 * 27.07.2021
 * 26. Java Collection API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Марсель");
        set.add("Виктор");
        set.add("Виктор");
        for (String value : set) {
            System.out.println(value);
        }
    }
}
