package ru.maxima;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 10.08.2021
 * 30. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "NumberUtil is working when")
public class NumbersUtilTest {
    // то, что мы будем тестировать
    private NumbersUtil numbersUtil;

    @BeforeEach
    public void setUp() {
        numbersUtil = new NumbersUtil();
    }

    @Nested
    @DisplayName("isPrime() is working")
    public class ForIsPrime {
        @ParameterizedTest(name = "return <true> on {0}")
        @ValueSource(ints = {2, 3, 71, 113})
        public void on_prime_numbers_return_true(int primeNumber) {
            assertTrue(numbersUtil.isPrime(primeNumber));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {121, 169})
        public void on_sqr_numbers_return_false(int sqrNumber) {
            assertFalse(numbersUtil.isPrime(sqrNumber));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ArgumentsSource(CompositeNumbersArgumentsProvider.class)
        public void on_composite_numbers_return_false(int number) {
            assertFalse(numbersUtil.isPrime(number));
        }

        @ParameterizedTest(name = "throws exception on {0}")
        @ValueSource(ints = {0, 1})
        public void on_bad_numbers_throws_exception(int badNumber) {
            assertThrows(IllegalArgumentException.class, () -> {
                numbersUtil.isPrime(badNumber);
            });
        }
    }

    @Nested
    @DisplayName("gcd() is working")
    public class ForGcd {
        @ParameterizedTest(name = "return {2} on number a = {0} and b = {1}")
//    @CsvSource(value = {"18, 12, 6", "9, 12, 3", "64, 48, 16"})
        @CsvFileSource(files = "src\\test\\resources\\gcd_data.csv")
        public void return_correct_result(int a, int b, int expected) {
            int actual = numbersUtil.gcd(a, b);
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("parse(String) is working")
    public class ForParse {
        //TODO: использовать provider, @ValueSource, @CsvFileSource/CsvSource, 100%

    }
}
