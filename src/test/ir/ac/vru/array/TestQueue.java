package test.ir.ac.vru.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ir.ac.vru.array.Queue;

public class TestQueue {
    private Queue queue;
    private final int size = 20;

    @BeforeEach
    public void init() {
        queue = new Queue(size);
    }

    @Test
    @DisplayName("Test enqueue")
    public void testEnqueue() {
        assertEquals(0, queue.length());
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        assertEquals(size - 1, queue.length());
    }

    @Test
    @DisplayName("Test dequeue")
    public void testDequeue() {
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < size - 1; i++) {
            assertEquals(i, queue.dequeue());
        }
        assertEquals(0, queue.length());
    }

    @Test
    @DisplayName("Test length")
    public void testLength() {
        assertEquals(0, queue.length());
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        assertEquals(size - 1, queue.length());
    }

    @Test
    @DisplayName("Test isEmpty")
    public void testIsEmpty() {
        assertEquals(true, queue.isEmpty());
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        assertEquals(false, queue.isEmpty());
    }

    @Test
    @DisplayName("Test isFull")
    public void testIsFull() {
        assertEquals(false, queue.isFull());
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        assertEquals(true, queue.isFull());
    }

    @Test
    @DisplayName("Test toString")
    public void testToString() {
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        assertEquals("Queue{size=20, front=0, rear=19, data=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, null]}", queue.toString());
    }

    @Test
    @DisplayName("Test clone")
    public void testClone() {
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        Queue clone = queue.clone();
        assertEquals(queue.toString(), clone.toString());
    }

    @Test
    @DisplayName("Test interleaving enqueu and dequeue")
    public void testInterleaving() {
        assertEquals(0, queue.length());
        for (int i = 0; i < 2 * size; i++) {
            queue.enqueue(i);
            assertEquals(1, queue.length());
            assertEquals(i, queue.dequeue());
            assertEquals(0, queue.length());
        }
        assertEquals(0, queue.length());
    }

    @Test
    @DisplayName("Test custome enqueu and dequeue")
    public void testCustome() {
        assertEquals(0, queue.length());
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(i);
        }
        assertEquals(size - 1, queue.length());
        assertEquals(0, queue.dequeue());
        assertEquals(size - 2, queue.length());
        for (int i = 1; i < queue.length() - 5; i++) {
            assertEquals(i, queue.dequeue());
//            System.out.println(queue.length());
//            System.out.println(queue.toString());
        }
//        System.out.println(queue.toString());
        assertEquals(12, queue.length());
        for (int i = 0; i < 5; i++) {
            queue.enqueue(7 * size + i);
        }
        assertEquals(17, queue.length());
        for (int i = 0; i < 12; i++) {
            assertEquals(7 + i, queue.dequeue());
        }
        assertEquals(5, queue.length());
        for (int i = 0; i < 5; i++) {
            assertEquals(7 * size + i, queue.dequeue());
        }
        assertEquals(0, queue.length());
    }
}
