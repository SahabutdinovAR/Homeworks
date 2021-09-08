package ru.maxima.reflection.solution.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 02.09.2021
 * 35. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsFramework {
    public <T extends Document> T generate(Class<T> documentClass, Object ... args) {
        // нам нужно понять, как сопоставить args и поля класса
        List<Class<?>> argsTypes = new ArrayList<>();

        for (Object argument : args) {
            argsTypes.add(argument.getClass());
        }
        // создаем массив для типов аргументов
        Class<?>[] argsTypesAsArray = new Class[argsTypes.size()];
        // перекидываем данные из списка в массив
        argsTypes.toArray(argsTypesAsArray);
        try {
            Constructor<T> documentConstructor = documentClass.getConstructor(argsTypesAsArray);
            // создаем документ с использованием указанного конструктора
            T document = documentConstructor.newInstance(args);
            processDefaultValueAnnotation(document);
            return document;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private <T extends Document> void processDefaultValueAnnotation(T document) {
        Class<T> documentClass = (Class<T>) document.getClass();
        Field[] fields = documentClass.getDeclaredFields();

        for (Field field : fields) {
            // хотим получить поля, которые помечены аннотацией DefaultValue
            DefaultValue defaultValueAnnotation = field.getAnnotation(DefaultValue.class);
            // если поле field помечено аннотацией DefaultValue
            if (defaultValueAnnotation != null) {
                // забираем значение, которым было помечено это поле
                String value = defaultValueAnnotation.value();
                // указываем возможность задания значения этого поля
                field.setAccessible(true);
                // в конкретный документ в конкретное поле кладем конкретное значение
                try {
                    field.set(document, value);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
    }
}
