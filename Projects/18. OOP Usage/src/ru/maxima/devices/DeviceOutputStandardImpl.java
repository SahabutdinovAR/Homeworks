package ru.maxima.devices;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DeviceOutputStandardImpl implements DeviceOutput {
    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public String getInformation() {
        return "Реализация на основе стандартного вывода";
    }
}
