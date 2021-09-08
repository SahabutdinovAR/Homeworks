package ru.maxima;

public class Main {

    public static void main(String[] args) {
	    Node a = new Node(10);
	    Node b = new Node(8);
	    Node c = new Node(11);
	    Node d = new Node(15);
	    Node e = new Node(20);
	    Node f = new Node(-10);
	    Node g = new Node(13);
	    Node h = new Node(5);
	    Node i = new Node(6);

	    a.setNext(b);
	    b.setNext(c);
	    c.setNext(d);
	    d.setNext(e);
	    e.setNext(f);
	    f.setNext(g);
	    g.setNext(h);
        h.setNext(i);

        Node current = a;

        while (current != null) {
			System.out.println(current.getValue());
			current = current.getNext();
		}
    }
}
