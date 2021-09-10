package maxima.reflection.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 02.09.2021
 * 35. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // получаем информацию о классе Unit в виде объекта типа Class
        Class<Unit> unitClass = Unit.class;

//        Class<?> unitClass = Class.forName("ru.maxima.reflection.example.Unit");
        // получить информацию обо всех методах класса Unit
        Method[] methods = unitClass.getDeclaredMethods();
        // проходим каждый метод класс Unit
        for (Method method : methods) {
            System.out.println(method.getReturnType().getName() + " " + method.getName());
        }
        // создать объект на основе информации о классе
        Unit newUnit = unitClass.newInstance();
        System.out.println(newUnit);

        // получили информацию о конструкторе
        Constructor<Unit> unitConstructor = unitClass.getConstructor(String.class);
        Unit anotherUnit = unitConstructor.newInstance("Марсель");
        System.out.println(anotherUnit);

        Constructor<Unit> anotherUnitConstructor = unitClass.getConstructor(String.class, Double.TYPE, Double.TYPE);
        Unit someUnit = anotherUnitConstructor.newInstance("Айрат", 10, 10);
        System.out.println(someUnit);
        // получили информацию о конкретном методе
        Method manaUpMethod = unitClass.getMethod("manaUp", double.class);
        manaUpMethod.invoke(someUnit, 15);
        System.out.println(someUnit);

        Method damageMethod = unitClass.getMethod("damage");
        double damageValue = (double) damageMethod.invoke(someUnit);
        System.out.println(damageValue);

        Field[] fields = unitClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType());
        }

        Field field = unitClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(someUnit, "Мегамэн");
        System.out.println(someUnit);
    }
}
