package ru.maxima;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 10.08.2021
 * 30. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CompositeNumbersArgumentsProvider implements ArgumentsProvider {

    private Random random = new Random();

    // Stream - обычный список
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        List<Arguments> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int first = random.nextInt(100) + 3; // случ число от 3 до 99
            int second = random.nextInt(100) + 3; // случ число от 3 до 99
            int compositeNumber = first * second; // у этого числа точно есть делители
            // из этого числа создали аргумент для модульного теста
            Arguments argument = Arguments.of(compositeNumber);
            // положили в список аргументов
            numbers.add(argument);
        }
        return numbers.stream(); // вернули стрим из списка
    }
}
