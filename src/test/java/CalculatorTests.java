import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CalculatorTests {
    Calculator sut;

    @BeforeAll
    public static void startedAll() {
        System.out.println("Все тесты стартовали!");
    }

    @BeforeEach
    public void started() {
        System.out.println("Данный тест стартовал");
        sut = new Calculator();
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Все тесты закончены!");
    }

    @AfterEach
    public void finished() {
        System.out.println("Данный тест закончен");
    }

    @Test
    public void deductionTest() {
        double a = 31, b = 11, expected = 20;

        double result = sut.deduction(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void additionTest() {
        double a = 31, b = 11, expected = 42;

        double result = sut.addition(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void multiplicationTest() {
        double a = 31, b = 11, expected = 341;

        double result = sut.multiplication(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void divisionTest() {
        int a = 31, b = 11, expected = 2;

        int result = sut.division(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void divisionByZeroTEst() {
        int a = 31, b = 0;
        var expected = ArithmeticException.class;

        Executable action = () -> sut.division(a, b);

        assertThrows(expected, action);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void linearEquationTest(int x, int expected) {

        int result = sut.linearEquation(x);

        assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(8, 64), Arguments.of(11, 91));
    }

    @Test
    public void polishNotationTestHamcrest() {
        String mathEq = "8 / 2 * 3 - 5 + 8";

        assertThat(mathEq, anyOf(containsString("2 * 3"), endsWith("5 + 8")));
    }

    @Test
    public void linearEquationTestHamcrest() {
        Integer intVal = 11;

        assertThat(intVal, allOf(greaterThan(1), not(equalTo(0))));
    }
}
