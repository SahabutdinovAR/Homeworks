package ru.maxima;

import ru.maxima.devices.*;
import ru.maxima.devices.impl.IOServiceImpl;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainBetter {
    public static void main(String[] args) {
        IOService service = new IOServiceImpl();

        DeviceInput scanner = new DeviceInputScanner();
        DeviceInput withPrefix = new DeviceInputWithPrefix("ОТ ПОЛЬЗОВАТЕЛЯ", scanner);
//        DeviceInput withTime = new DeviceInputWithTime(withPrefix);
        DeviceInput withAnotherPrefix = new DeviceInputWithPrefix("ПОЛУЧЕНО СООБЩЕНИЕ В ", withPrefix);

        DeviceOutput deviceOutput = new DeviceOutputStandardImpl();

        service.setInput(withAnotherPrefix);
        service.setOutput(deviceOutput);

        service.printInformationAboutDevices();

        while (true) {
            String message = service.read();
            service.write(message);
        }
    }
}
