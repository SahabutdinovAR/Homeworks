package ru.maxima.custom;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * 30.07.2021
 * 28. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        PasswordValidator passwordValidator = new PasswordValidator();

        passwordValidator.validate(password);
    }
}
