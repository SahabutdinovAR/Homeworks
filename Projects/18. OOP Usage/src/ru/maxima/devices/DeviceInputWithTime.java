package ru.maxima.devices;

import java.time.LocalTime;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DeviceInputWithTime implements DeviceInput {
    private DeviceInput deviceInput;

    public DeviceInputWithTime(DeviceInput deviceInput) {
        this.deviceInput = deviceInput;
    }

    @Override
    public String read() {
        return LocalTime.now() + ":" + deviceInput.read();
    }

    @Override
    public String getInformation() {
        return "Реализация входного потока со временем на базе " + deviceInput.getInformation();
    }
}
