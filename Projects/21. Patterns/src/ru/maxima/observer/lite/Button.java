package ru.maxima.observer.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// Observable
public interface Button {
    // данный метод (NotifyObservers + addObserver)
    // реакция на нажатие кнопки
    void onClick(ClickReaction reaction);
    // нажатие кнопки
    void click();
}
