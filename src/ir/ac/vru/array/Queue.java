package ir.ac.vru.array;

import java.util.Arrays;

public class Queue<T> {
    private int size;
    private int front;
    private int rear;
    private T[] data;

    public Queue(int size) {
        this.size = size;
        front = 0;
        rear = 0;
        data = (T[]) new Object[size];
    }

    public Queue(Queue<T> queue) {
        size = queue.size;
        front = queue.front;
        rear = queue.rear;
        data = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            data[i] = queue.data[i];
        }
    }

    public void enqueue(T element) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (rear == size) {
            // we are at the end of the array
            rear = 0;
        }
        data[rear++] = element;
    }

    public T dequeue() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (front == size) {
            front = 0;
        }
        return data[front++];
    }

    public T peek() {
        return data[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public int getSize() {
        return size;
    }

    public int length() {
        return (size + rear - front) % size;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "size=" + size +
                ", front=" + front +
                ", rear=" + rear +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public Queue<T> clone() {
        return new Queue<>(this);
    }
}
