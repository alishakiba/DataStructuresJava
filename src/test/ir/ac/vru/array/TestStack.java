package test.ir.ac.vru.array;

import ir.ac.vru.array.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStack {
    private Stack stack;
    private final int size = 20;

    @BeforeEach
    public void init() {
        stack = new Stack(this.size);
    }

    @Test
    @DisplayName("Test Stack push")
    public void testPush() {
        assertEquals(true, stack.isEmpty());
        for (int i = 0; i < this.size; i++) {
            stack.push(i);
            assertEquals(i, stack.peek());
        }
        assertEquals(true, stack.isFull());
    }

    @Test
    @DisplayName("Test Stack pop")
    public void testPop() {
        for (int i = 0; i < this.size; i++) {
            stack.push(i);
        }
        for (int i = this.size - 1; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertEquals(true, stack.isEmpty());
    }

    @Test
    @DisplayName("Test Stack peek")
    public void testPeek() {
        for (int i = 0; i < this.size; i++) {
            stack.push(i);
            assertEquals(i, stack.peek());
        }
    }

    @Test
    @DisplayName("Test Stack isEmpty")
    public void testIsEmpty() {
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    @DisplayName("Test Stack isFull")
    public void testIsFull() {
        assertEquals(false, stack.isFull());
        for (int i = 0; i < this.size; i++) {
            stack.push(i);
        }
        assertEquals(true, stack.isFull());
    }

    @Test
    @DisplayName("Test Stack toString")
    public void testToString() {
        assertEquals("[]", stack.toString());
        for (int i = 0; i < this.size; i++) {
            stack.push(i);
        }
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]", stack.toString());
    }

    @Test
    @DisplayName("Test Stack clone method")
    public void testClone() {
        for (int i = 0; i < this.size; i++) {
            stack.push(i);
        }
        Stack clone = stack.clone();
        assertEquals(stack.toString(), clone.toString());
        while (! clone.isEmpty()) {
            clone.pop();
        }
        assertEquals(true, clone.isEmpty());
        assertEquals(false, stack.isEmpty());
        assertNotEquals(stack.toString(), clone.toString());
        assertNotEquals(stack.length(), clone.length());
    }
}
