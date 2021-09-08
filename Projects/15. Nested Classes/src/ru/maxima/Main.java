package ru.maxima;

public class Main {

    public static void main(String[] args) {
	    Table table = new Table();
	    table.put("Марсель", 27);
	    table.put("Даниил", 21);
	    table.put("Айрат", 22);
	    table.put("Максим", 21);

	    Table table1 = new Table();
	    table1.put("Ильгам", 23);
	    table1.put("Салават", 25);

        System.out.println(table.get("Айрат")); // 22
        System.out.println(table.get("Максим")); // 21

		Table.Iterator iterator1 = table.new Iterator();
		Table.Iterator iterator2 = table.new Iterator();

		while (iterator1.hasNext()) {
			// экземпляр вложенного класса
			Table.TableEntry entry = iterator1.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		while (iterator2.hasNext()) {
			// экземпляр вложенного класса
			Table.TableEntry entry = iterator2.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		Table.Iterator iterator3 = table1.new Iterator();
		while (iterator3.hasNext()) {
			// экземпляр вложенного класса
			Table.TableEntry entry = iterator3.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
    }
}
