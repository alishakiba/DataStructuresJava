package ir.ac.vru.list;

import ir.ac.vru.array.Queue;

import java.util.Arrays;

public class SinglyLLQueue<T> {

    SinglyLinkedList data;

    SinglyLLQueue() {
        data = new SinglyLinkedList();
    }

    public void enqueue(T element) throws IllegalStateException {
        SingleNode<T> node = new SingleNode<T>(element);
        this.data.addLast(node);
    }

    public T dequeue() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        else {
            SingleNode<?> node = this.data.first();
            this.data.removeFirst();
            return (T) node.getValue();
        }
    }

    public T peek() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        else {
            SingleNode<?> node = this.data.first();
            return (T) node.getValue();
        }
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public int length() {
        return this.data.size();
    }

    @Override
    public String toString() {
        // TODO:
        throw new IllegalStateException("Not implemented");
        // return null;
    }

    public Queue<T> clone() {
        // TODO:
        throw new IllegalStateException("Not implemented");
        // return null;
    }

}
