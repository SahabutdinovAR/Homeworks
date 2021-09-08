package ru.maxima.reflection.solution.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 02.09.2021
 * 35. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface DefaultValue {
    String value();
}
