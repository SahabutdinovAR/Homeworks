package ru.maxima;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 27.07.2021
 * 26. Java Collection API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.push("Марсель");
        stack.push("Айрат");
        stack.push("Даниил");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
