package ru.maxima;

import ru.maxima.devices.DeviceInput;
import ru.maxima.devices.DeviceInputScanner;
import ru.maxima.devices.DeviceInputWithPrefix;
import ru.maxima.devices.DeviceInputWithTime;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainDevices {
    public static void main(String[] args) {
        DeviceInput scanner = new DeviceInputScanner();
        DeviceInput withPrefix = new DeviceInputWithPrefix("ОТ ПОЛЬЗОВАТЕЛЯ", scanner);
        DeviceInput withTime = new DeviceInputWithTime(withPrefix);
        DeviceInput withAnotherPrefix = new DeviceInputWithPrefix("ПОЛУЧЕНО СООБЩЕНИЕ В ", withTime);

        String message = withAnotherPrefix.read();
        System.out.println(message);
    }
}
