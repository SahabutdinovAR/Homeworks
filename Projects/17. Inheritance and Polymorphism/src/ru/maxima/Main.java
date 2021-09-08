package ru.maxima;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class Main {

    public static void main(String[] args) {
        Athlete bolt = new Athlete("Усейн Болт", 35, 10);
        Workman marsel = new Workman("Марсель", 27, 10);
        Student maxim = new Student("Максим", 22, 4.5);

        bolt.go();
        marsel.go();
        maxim.go();

        bolt.run();
        marsel.run();
        maxim.run();

        System.out.println(bolt.getStepsCount());
        System.out.println(marsel.getStepsCount());
        System.out.println(maxim.getStepsCount());
    }
}
