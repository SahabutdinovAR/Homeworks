package ru.maxima;

public class Main {

    public static void main(String[] args) {
        // marsel - объектная переменная, указывает на экземпляр класса (объект) в памяти
	    Human marsel = new Human(); // аналог. Human *marsel = new Human;
        marsel.height = 1.85;
        marsel.isWorker = false;
        marsel.grow(0.10);

        Human maxim = new Human();
        maxim.height = 1.69;
        maxim.isWorker = true;

        maxim.relax();

        System.out.println(marsel.height + "  " + marsel.isWorker);
        System.out.println(maxim.height + "  " + maxim.isWorker);
    }
}
