package ru.maxima.examples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainNoSuchElementException {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Привет" , "Пока!");
        Iterator<String> iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
