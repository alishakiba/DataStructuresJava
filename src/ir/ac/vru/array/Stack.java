package ir.ac.vru.array;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] data;
    private int top;
    private int size;

    public Stack(int size) {
        data = (T[]) new Object[size];
        this.size = size;
        this.top = -1;
    }

    public Stack(Stack<T> stack) {
        this(stack.size());
        this.data = (T[]) new Object[size];
        for (int i = 0; i < stack.size(); i++) {
            data[i] = stack.data[i];
        }
        top = stack.top;
    }

    public void push(T item) throws StackOverflowError {
//        if (this.isFull()) {
        if (top == data.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        data[++top] = item;
        /*
        top++;
        data[top] = item;
         */
    }

    public T pop() throws EmptyStackException {
        // if (this.isEmpty()) {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return data[top--];
        /*
        T temp = data[top];
        top--;
        return temp;
         */
    }

    public T peek() throws EmptyStackException {
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
        return size;
    }

    public void clear() {
        top = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length(); i++) {
            sb.append(data[i]);
            if (i != length() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Stack<T> clone() {
        Stack<T> stack = new Stack<T>(this.size);
        for(int i = 0; i <= this.top; i++) {
            stack.push(this.data[i]);
        }
        return stack;
    }
}
