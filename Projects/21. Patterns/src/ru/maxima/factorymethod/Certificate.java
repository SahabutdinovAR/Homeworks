package ru.maxima.factorymethod;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Certificate implements Document {

    private String text;
    private String title;

    public Certificate(String title, String text) {
        this.text = text;
        this.title = title;
    }

    @Override
    public String getText() {
        return "СПРАВКА - " + text;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
