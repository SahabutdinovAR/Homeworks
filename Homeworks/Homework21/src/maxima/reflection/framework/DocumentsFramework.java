package maxima.reflection.framework;

import maxima.reflection.solution.Certificate;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class DocumentsFramework {
    private CheckRange checkRange;


    public <T extends Document> T generate(Class<T> documentClass, Object... args) {
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
    }

    public <T extends Document> void processingCheckRangeAnnotation(Document document) {
        Class<T> documentClass = (Class<T>) document.getClass();
        Field[] fields = documentClass.getDeclaredFields();

        for (Field field : fields) {
            // хотим получить поля, которые помечены аннотацией CheckRange
            CheckRange CheckRangeAnnotation = field.getAnnotation(CheckRange.class);
            // если поле field помечено аннотацией CheckRange
            if (CheckRangeAnnotation != null) {
                // забираем значение, которым было помечено это поле
                int min = checkRange.min();
                int max = checkRange.max();
                int value = Certificate.getActiveYears();
                // указываем возможность задания значения этого поля
                field.setAccessible(true);
                // в конкретный документ в конкретное поле кладем конкретное значение
            } else {
                throw new IllegalStateException();
                try {
                    field.set(document, value);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }

                private <T extends Document > void processDefaultValueAnnotation (T document){
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
        }
    }
}



