package ru.maxima.proxy.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// TaxiService - клиент класса Driver
public class TaxiService {
    public void setOnLine(Driver[] drivers) {
        for (int i = 0; i < drivers.length; i++) {
            drivers[i].drive();
        }
    }
}
