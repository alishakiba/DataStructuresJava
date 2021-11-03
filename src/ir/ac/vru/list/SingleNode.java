package ir.ac.vru.list;

public class SingleNode<T> {
    protected T value;
    protected SingleNode next;

    public SingleNode(T value, SingleNode next) {
        this.value = value;
        this.next = next;
    }

    public SingleNode(T value) {
        this(value, null);
    }

    public SingleNode(SingleNode<T> node) {
        this.value = node.value;
        this.next = node.next;
    }

    public T getValue() {
        return value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

}
