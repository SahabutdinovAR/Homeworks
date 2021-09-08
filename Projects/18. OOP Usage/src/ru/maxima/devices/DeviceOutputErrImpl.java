package ru.maxima.devices;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DeviceOutputErrImpl implements DeviceOutput {
    @Override
    public void write(String message) {
        System.err.println(message);
    }

    @Override
    public String getInformation() {
        return "Реализация на основе err-потока";
    }
}
