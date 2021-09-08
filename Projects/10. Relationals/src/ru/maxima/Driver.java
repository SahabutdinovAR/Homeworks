package ru.maxima;

/**
 * 18.06.2021
 * 10. Relationals
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Driver {
    // поля

    // имя водителя
    private String name;
    // количество опыта (в годах)
    private int experience;
    // поле, которое хранит ссылку на автобус, которым управляет водитель
    private Bus bus;

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void setBus(Bus bus) {
        // если еще не было автобуса
        if (this.bus == null) {
            // запомнили автобус, которым мы управляем
            this.bus = bus;
            // автобусу тоже задали нас в качестве водителя
            this.bus.setDriver(this);
        } else {
            System.err.println("У водителя уже есть автобус!");
        }
    }

    public void drive() {
        if (this.bus != null) {
            this.bus.go();
        } else {
            System.err.println("Водитель без автобуса!");
        }
    }
}
