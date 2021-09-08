package ru.maxima.object;

/**
 * 02.07.2021
 * 20. String and Object
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class EqualsUtil {
    // здесь мы хотим, чтобы можно было сравнить между собой список объектов
    // совершенно разного типа (в том числе и Point)
    // поскольку, я хочу разные типы, мне необходимо здесь указать супертип Object
    public static boolean isEquals(Object ... objects) {
        for (int i = 0; i < objects.length - 1; i++) {
            // тут я полагаю, что если я сравниваю какие-то неизвестные мне объекты между собой
            // то у них реализован equals
            // следовательно, я вызываю именно этот метод для проверки эквивалентности
            // НО! поскольку у меня тут переменные типа Object, у меня вызывается метод с сигнатурой
            // equals(Object object), но в Point у меня определен equals(Point point) и он вызван не будет
            // будет вызван метод, который определен в Object, а именно this == obj и следовательно,
            // все сработает не так, как надо
            // ПОЭТОМУ! каждый класс должен переопределить equals с той же сигнатурой, что и в Object
            if (!objects[i].equals(objects[i+1])) {
                return false;
            }
        }
        return true;
    }
}
