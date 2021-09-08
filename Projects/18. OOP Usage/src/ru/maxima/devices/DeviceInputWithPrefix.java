package ru.maxima.devices;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DeviceInputWithPrefix implements DeviceInput {

    // принимаю на вход устройство для чтения
    private DeviceInput deviceInput;
    private String prefix;

    public DeviceInputWithPrefix(String prefix, DeviceInput deviceInput) {
        this.deviceInput = deviceInput;
        this.prefix = prefix;
    }

    @Override
    public String read() {
        return prefix + ": " + deviceInput.read();
    }

    @Override
    public String getInformation() {
        return "Реализация входного потока с префиксом на базе " + deviceInput.getInformation();
    }
}
