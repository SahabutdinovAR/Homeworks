package ru.maxima.devices;

import java.util.Scanner;

/**
 * 27.06.2021
 * 18. OOP Usage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class AbstractDeviceInputScanner implements DeviceInput {
    private Scanner scanner;

    public AbstractDeviceInputScanner() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
