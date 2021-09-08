package ru.maxima.devices.impl;

import ru.maxima.devices.DeviceInput;
import ru.maxima.devices.DeviceOutput;
import ru.maxima.devices.IOService;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class IOServiceImpl implements IOService {

    private DeviceInput input;
    private DeviceOutput output;

    @Override
    public void setInput(DeviceInput input) {
        this.input = input;
    }

    @Override
    public void setOutput(DeviceOutput output) {
        this.output = output;
    }

    @Override
    public String read() {
        return input.read();
    }

    @Override
    public void write(String message) {
        output.write(message);
    }

    @Override
    public void printInformationAboutDevices() {
        System.out.println(input.getInformation());
        System.out.println(output.getInformation());
    }
}
