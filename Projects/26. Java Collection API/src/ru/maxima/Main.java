package ru.maxima;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Марсель");
        queue.offer("Айрат");
        queue.offer("Виктор");
        queue.offer("Даниил");
        queue.offer("Максим");

        for (String value : queue) {
            System.out.println(value);
        }

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
