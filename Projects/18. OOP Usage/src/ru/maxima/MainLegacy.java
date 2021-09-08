package ru.maxima;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainLegacy {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    String message = scanner.nextLine();

	    while (true) {
            System.err.println("ОТ ПОЛЬЗОВАТЕЛЯ: " + message + " в " +
                    LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond());
            message = scanner.nextLine();
        }
    }
}
