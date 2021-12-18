package ir.ac.vru.list;

import java.util.EmptyStackException;

public class Stack<T> {

    SinglyLinkedList data;

    public Stack() {
        data = new SinglyLinkedList();
    }

    public void push(T item) {
        SingleNode<T> node = new SingleNode<>(item);
        data.addFirst(node);
    }

    public T pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            SingleNode<?> node = this.data.first;
            this.data.removeFirst();
            return (T) node.getValue();
        }
    }

    public T peek() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return (T) this.data.first.getValue();
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int length() {
        return this.data.size();
    }

    public void clear() {
        while(!this.data.isEmpty()) {
            this.data.removeFirst();
        }
    }

    public String toString() {
        // TODO:
        return null;
    }

    public ir.ac.vru.list.Stack<T> clone() {
        // TODO:
        return null;
    }
}
