package ir.ac.vru.tree;

public class BinaryNode<T extends Comparable<T>> implements Comparable<BinaryNode<T>> {
    protected T data;
    protected BinaryNode left;
    protected BinaryNode right;
    protected BinaryNode parent;

    public BinaryNode(T data) {
        this(data, null, null, null);
    }

    public BinaryNode(T data, BinaryNode left, BinaryNode right, BinaryNode parent) {
        this.data = data;
        this.left = left;
        this.parent = parent;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    @Override
    public BinaryNode clone() {
        return new BinaryNode(data, left, right, parent);
    }

    @Override
    public int compareTo(BinaryNode<T> o) {
        return data.compareTo(o.data);
    }

    public BinaryNode getParent() {
        return parent;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }
}
