package ru.maxima.proxy.hard;

import java.time.LocalTime;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MailServiceImpl implements MailService {
    @Override
    public void sendMessage(String email, String text) {
        System.out.println("На " + email + " было отправлено сообщение - " + text + " в " + LocalTime.now());
    }
}
