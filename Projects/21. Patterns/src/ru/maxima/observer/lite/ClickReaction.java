package ru.maxima.observer.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// Observer
public interface ClickReaction {
    // данный метод вызывается, когда происходит какое-то событие
    void handle();
}
