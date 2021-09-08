package ru.maxima;

public class Main {

    public static void main(String[] args) {
    	Driver anatoliy = new Driver("Анатолий", 10);
    	Driver viktor = new Driver("Виктор", 15);

    	// создаем объекты
	    Bus bus55 = new Bus(55, "НЕФАЗ");
	    Bus bus22 = new Bus(22, "НЕФАЗ");

	    Passenger maxim = new Passenger("Максим");
	    Passenger marsel = new Passenger("Марсель");
	    Passenger aliya = new Passenger("Алия");
	    Passenger daniil = new Passenger("Даниил");
		Passenger ilgam = new Passenger("Ильгам");
		Passenger salavat = new Passenger("Салават");
		// отправляем пассажиров в автобусы
		maxim.goToBus(bus55);
		marsel.goToBus(bus55);
		aliya.goToBus(bus55);
		daniil.goToBus(bus55);

		ilgam.goToBus(bus22);
		salavat.goToBus(bus22);

		marsel.goToBus(bus22);

		viktor.setBus(bus55);
		anatoliy.setBus(bus22);

		viktor.drive();
		anatoliy.drive();
    }
}
