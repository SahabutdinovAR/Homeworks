package ru.maxima.observer.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ExitButton implements Button {
    // аналог observers[], но только один представитель
    private ClickReaction reaction;

    @Override
    public void onClick(ClickReaction reaction) {
        this.reaction = reaction;
    }

    @Override
    public void click() {
        System.out.println("Выходим из приложения");
        reaction.handle();
    }
}
