package ru.maxima.proxy.hard;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MailServiceProxy implements MailService {
    private MailService mailService;

    private Before before;
    private After after;

    public MailServiceProxy(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void sendMessage(String email, String text) {
        if (before != null) {
            before.before();
        }
        this.mailService.sendMessage(email, text);
        if (after != null) {
            after.after();
        }
    }

    public void setBefore(Before before) {
        this.before = before;
    }

    public void setAfter(After after) {
        this.after = after;
    }
}
