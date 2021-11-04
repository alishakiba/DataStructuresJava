package ir.ac.vru.array;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] data;
    private int top;

    public Stack(int size) {
        data = (T[]) new Object[size];
        top = -1;
    }

    public void push(T item) {
        if (top == data.length - 1) {
            throw new StackOverflowError();
        }
        data[++top] = item;
    }

    public T pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return data[top--];
    }

    public T peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public int length() {
        return top + 1;
    }

    public int size() {
        return data.length;
    }
}
