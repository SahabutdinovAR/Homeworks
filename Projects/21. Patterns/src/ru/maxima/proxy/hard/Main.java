package ru.maxima.proxy.hard;

import java.util.Scanner;
import java.util.UUID;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MailService mailService = new MailServiceImpl();
        MailServiceProxy proxy = new MailServiceProxy(mailService);
        proxy.setBefore(() -> System.out.println("Инициализация SMTP, открытие соединения"));
        proxy.setAfter(() -> System.out.println("Закрытие соединения"));

        UsersService usersService = new UsersService(proxy);

        while (true) {
            System.out.println("1. Регистрация");
            System.out.println("2. Вход");
            System.out.println("3. Обновить пароль");

            int command = scanner.nextInt();
            scanner.nextLine();

            String email = scanner.nextLine();

            switch (command) {
                case 1: {
                    String password = scanner.nextLine();
                    usersService.signUp(email, password);
                }
                break;
                case 2: {
                    String password = scanner.nextLine();
                    usersService.signIn(email, password);
                }
                break;
                case 3: {
                    usersService.resetPassword(email);
                }
            }
        }
    }
}
