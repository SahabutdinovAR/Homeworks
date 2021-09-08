package ru.maxima.factorymethod;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Statement implements Document {
    private String title;
    private String text;

    public Statement(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getText() {
        return "ЗАЯВЛЕНИЕ - " + text;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
