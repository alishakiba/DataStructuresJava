package test.ir.ac.vru.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitTesting {
    @Test
    @DisplayName("Check whether 1 not equals to 2")
    public void testBasicAssertion() {
        Assertions.assertNotEquals(1, 2);
    }

    @Test
    @DisplayName("Multiple Assertions")
    public void testMultipleAssertions() {
        int[] numbers = {1,2,3,4,5};
        assertEquals(1, numbers[0]);
        assertEquals(2, numbers[1]);
        assertEquals(3, numbers[2]);
        assertEquals(4, numbers[3]);
        assertEquals(5, numbers[4]);
    }

    @Test
    @DisplayName("Multiple Assertions at the same time")
    public void testMultipleAssertionsAtTheSameTime() {
        int[] numbers = {1,2,3,4,5};
        Assertions.assertAll(
                () -> assertEquals(1, numbers[0]),
                () -> assertEquals(2, numbers[1]),
                () -> assertEquals(3, numbers[2]),
                () -> assertEquals(4, numbers[3]),
                () -> assertEquals(5, numbers[4])
        );
    }

    @ParameterizedTest (name = "{0}")
    @DisplayName("Parameterized test is introduced")
    @ValueSource(ints = {2,3,4,5,6})
    public void testParameterizedTest(int i) {
        int j = i + 1;
        if (i < 4)
            assertEquals(i+1, j);
        else
            assertEquals(i+1, i);
    }
}
