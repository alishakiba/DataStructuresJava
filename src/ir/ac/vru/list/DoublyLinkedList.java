package ir.ac.vru.list;

public class DoublyLinkedList {
    protected int size;
    protected DoubleNode<?> first;

    public DoublyLinkedList() {
        this.size = 0;
        this.first = null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public DoubleNode<?> first() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("List is empty.");
        else
            return this.first;
    }

    public DoubleNode<?> last() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("List is empty.");
        else {
            DoubleNode<?> currentNode = this.first;
            for(int i = 1; i < this.size; ++i) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }
    }

    public DoubleNode<?> getAt(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.size)
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds (" + this.size + ").");
        else {
            DoubleNode<?> node = this.first;
            for(int j = 0; j < i; ++j) {
                node = node.getNext();
            }
            return node;
        }
    }

    public void removeFirst() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("List is empty.");
        else if (this.size == 1) {
            this.first = null;
        }
        else {
            DoubleNode<?> node = this.first;
            this.first = node.getNext();
            this.first.setPrev(null);
            node.setNext(null);
            node.setPrev(null);
        }
        this.size--;
    }

    public void removeLast() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("List is empty.");
        else if (this.size == 1) {
            this.first = null;
        }
        else {
            DoubleNode<?> node = this.first;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            DoubleNode<?> previosNode = node.getPrev();
            previosNode.setNext(null);
            node.setNext(null);
            node.setPrev(null);
        }
        this.size--;
    }

    public void addFirst(DoubleNode<?> node) {
        if (this.isEmpty()) {
            this.first = node;
            node.setNext(null);
            node.setPrev(null);
        }
        else {
            node.setNext(this.first);
            node.setPrev(null);
            this.first.setPrev(node);
            this.first = node;
        }
        this.size++;
    }

    public void addLast(DoubleNode<?> node) {
        if (this.isEmpty()) {
            this.first = node;
            node.setNext(null);
            node.setPrev(null);
        }
        else {
            node.setNext(null);
            DoubleNode<?> lastNode = this.last();
            lastNode.setNext(node);
            node.setPrev(lastNode);
        }
        this.size++;
    }
}
