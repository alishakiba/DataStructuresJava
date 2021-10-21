package test.ir.ac.vru.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitTesting {
    @Test
    @DisplayName("Check whether 1 not equals to 2")
    public void testBasicAssertion() {
        Assertions.assertNotEquals(1, 1);
    }

    @Test
    @DisplayName("Multiple Assertions")
    public void testMultipleAssertions() {
        int[] numbers = {1,2,3,4,5};
        assertEquals(1, numbers[0]);
        assertEquals(2, numbers[1]);
        assertEquals(7, numbers[2]);
        assertEquals(4, numbers[3]);
        assertEquals(8, numbers[4]);
    }

    @Test
    @DisplayName("Multiple Assertions at the same time")
    public void testMultipleAssertionsAtTheSameTime() {
        int[] numbers = {1,2,3,4,5};
        Assertions.assertAll(
                () -> assertEquals(1, numbers[0]),
                () -> assertEquals(2, numbers[1]),
                () -> assertEquals(7, numbers[2]),
                () -> assertEquals(4, numbers[3]),
                () -> assertEquals(8, numbers[4])
        );
    }
}
