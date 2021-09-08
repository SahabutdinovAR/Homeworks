package ru.maxima.proxy.hard;

import java.util.UUID;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersService {

    private MailService mailService;

    public UsersService(MailService mailService) {
        this.mailService = mailService;
    }

    public void signUp(String email, String password) {
        System.out.println("Регистрация прошла успешно!");
        mailService.sendMessage(email, "Вы зарегистрированы на сайте");
    }

    public void signIn(String email, String password) {
        System.out.println("Вход прошел успешно!");
        mailService.sendMessage(email, "Был выполнен вход на сайт");
    }

    public void resetPassword(String email) {
        System.out.println("Заявка на смену пароля направлена.");
        mailService.sendMessage(email, "Ваш новый пароль - " + UUID.randomUUID().toString());
    }
}
