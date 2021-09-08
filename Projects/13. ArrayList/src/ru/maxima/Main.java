package ru.maxima;

public class Main {

    public static void main(String[] args) {
	    ArrayList list = new ArrayList();
	    list.add(10);
	    list.add(15);
	    list.add(20);
	    list.add(25);
	    list.add(30);
	    list.add(35);
	    list.add(40);
	    list.add(45);
	    list.add(55);
	    list.add(60);
	    list.add(65);
	    list.add(70);
	    list.add(75);
	    list.add(80);

		System.out.println(list.size()); // 14
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println(list.get(15)); // Index out of bounds
    }
}
