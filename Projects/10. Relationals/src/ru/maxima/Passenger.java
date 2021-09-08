package ru.maxima;

/**
 * 16.06.2021
 * 10. Relationals
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Passenger {
    // поля

    // имя пассажира
    private String name;
    // статус - в автобусе ли находится пассажир?
    private boolean inBus;
    // ссылка на автобус, внутри которого мы сейчас находимся
    private Bus bus;

    // конструктор - принимает на вход имя пассажира
    public Passenger(String name) {
        this.name = name;
        // по умолчанию пассажир не в автобусе
        this.inBus = false;
    }
    // геттер для получения имени
    public String getName() {
        return name;
    }

    // метод для отправки пассажира в автобус
    public void goToBus(Bus bus) {
        // если пассажир еще не в автобусе
        if (!inBus) {
            // вызываем у автобуса метод для того, чтобы пустить пассажира (себя)
            if (bus.getPassenger(this)) {
                // если успешно удалось сесть
                inBus = true;
                // сохранили у пассажира ссылку на автобус, в котором он находится
                this.bus = bus;
            }
        } else {
            System.err.println(name + " - Я УЖЕ ЕДУ в автобусе " + this.bus.getModel()
                    + " " + this.bus.getNumber());
        }
    }

    public boolean isInBus() {
        return inBus;
    }
}
