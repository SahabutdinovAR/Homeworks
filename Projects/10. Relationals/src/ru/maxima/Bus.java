package ru.maxima;

/**
 * 16.06.2021
 * 10. Relations
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Bus {
    // максимальное количество пассажиров (константа, ее значение менять нельзя)
    private final int MAX_PASSENGERS_COUNT = 3;
    // поля

    // номер автобуса
    private int number;
    // модель автобуса
    private String model;
    // массив пассажиров
    private Passenger[] passengers;
    // количество пассажиров, которые есть на данный момент в автобусе
    private int passengersCount;
    // поле, которое хранит ссылку на водителя
    private Driver driver;

    // конструктор, принимает параметры, которое затем передаются в поля конкретного объекта
    public Bus(int number, String model) {
        // this - ключевое слово для обращения к членам класса
        this.number = number;
        this.model = model;
        // создали пассив на троих пассажиров, инзначально массив пустой, но содержит три объектные переменные
        // в которые мы можем положить значения
        this.passengers = new Passenger[MAX_PASSENGERS_COUNT];
        this.passengersCount = 0;
    }
    // метод для того, чтобы "пустить" пассажира в автобус
    // на вход принимает объектную переменную типа Passenger, которая содержит указатель на пассжира
    public boolean getPassenger(Passenger passenger) {
        // если текущее количество пассажиров не превышает максимальное
        if (passengersCount < MAX_PASSENGERS_COUNT) {
            // кладем в массив пассажира
            // [ ] [ ] [ ], count = 0
            // [*] [ ] [ ], count = 1
            // [*] [*] [ ], count = 2
            // [*] [*] [*], count = 3
            passengers[passengersCount] = passenger;
            // увеличиваем количество пассажиров на текущий момент
            passengersCount++;
            // возвращаем true, если пассажир успешно сел в автобус
            return true;
        } else {
            System.err.println("Автобус переполнен!");
            // false если он не мог сесть
            return false;
        }
    }

    public void go() {
        // когда есть водитель
        if (driver != null) {
            System.out.println("Автобус " + model +
                    " " + number + " едет под управлением " + driver.getName() + " со стажем вождения " +
                    driver.getExperience() + " лет");
            System.out.println("С нами едут:");
            for (int i = 0; i < passengersCount; i++) {
                System.out.println(passengers[i].getName());
            }
        } else {
            System.err.println("Автобус без водителя!!!");
        }
    }

    public void setDriver(Driver driver) {
        // если еще не было водителя
        if (this.driver == null) {
            this.driver = driver;
        } else {
            System.err.println("Автобус уже занят!");
        }
    }

    public String getModel() {
        return model;
    }

    public int getNumber() {
        return number;
    }
}
