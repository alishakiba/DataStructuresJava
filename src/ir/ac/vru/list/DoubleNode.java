package ir.ac.vru.list;

public class DoubleNode<T> {
    protected T value;
    protected DoubleNode<?> next;
    protected DoubleNode<?> prev;

    public DoubleNode(T value, DoubleNode<?> prev, DoubleNode<?> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode(T value) {
        this(value, null, null);
    }

    public DoubleNode(DoubleNode<T> node) {
        this.value = node.value;
        this.next = node.next;
        this.prev = node.prev;
    }

    public T getValue() {
        return value;
    }

    public DoubleNode<?> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(DoubleNode<?> next) {
        this.next = next;
    }

    public DoubleNode<?> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<?> prev) {
        this.prev = prev;
    }
}
