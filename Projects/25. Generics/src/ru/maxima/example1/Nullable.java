package ru.maxima.example1;

/**
 * 20.07.2021
 * 25. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// обертка, которая позволяет избежать nullpointer-а
// программист всегда знает, что раз класс возвращает Nullable, значит надо проверить на null
public class Nullable<T> {
    private T value;

    private Nullable(T value) {
        this.value = value;
    }

    // обобщенный метод
    // Данный метод говорит о том, что будет возвращен объект типа Nullable<E>, при этом
    // E подставляется в T, а откуда метод узнает, какой у E? он поймет исходя из типа value
    // т.е если вызывается Nullable.of("Привет"), то происходит следующая цепочка
    // String -> E -> Nullable<T> -> Nullable<String>
    public static <E> Nullable<E> of(E value) {
        return new Nullable<>(value);
    }

    // а тут что? а тут null
    public static <T> Nullable<T> empty() {
        return new Nullable<>(null);
    }

    // метод выдает true, если объект есть, false - если нет
    public boolean isPresent() {
        return this.value != null;
    }


    // метод возвращает значение
    public T get() {
        return value;
    }
}
