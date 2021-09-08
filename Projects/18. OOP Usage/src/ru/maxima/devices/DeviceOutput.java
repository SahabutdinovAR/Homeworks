package ru.maxima.devices;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface DeviceOutput extends Device {
    void write(String message);
}
