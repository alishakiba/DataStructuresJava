package ir.ac.vru.list;

public class SinglyLinkedList {
    protected int size;
    protected SingleNode<?> first;

    public SinglyLinkedList() {
        this.size = 0;
        this.first = null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public SingleNode<?> first() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("List is empty.");
        else
            return this.first;
    }

    public SingleNode<?> last() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("List is empty.");
        else {
            SingleNode<?> currentNode = null;
            for (
                    currentNode = first;
                    currentNode.next != null;
                    currentNode = currentNode.next
            );
            return currentNode;
        }
    }

    public void removeFirst() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("List is empty.");
        else if (this.size == 1) {
            this.first = null;
        }
        else {
            SingleNode<?> node = this.first;
            this.first = node.getNext();
            this.first.setNext(null);
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
            SingleNode<?> previous_node = this.first;
            SingleNode<?> current_node = previous_node.getNext();
            while (current_node.getNext() != null) {
                previous_node = current_node;
                current_node = previous_node.getNext();
            }
            previous_node.setNext(null);
        }
        this.size--;
    }

    public void addFirst(SingleNode<?> node) {
        if (this.isEmpty()) {
            this.first = node;
            node.setNext(null);
        }
        else {
            node.setNext(this.first);
            this.first = node;
        }
        this.size++;
    }

    public void addLast(SingleNode<?> node) {
        if (this.isEmpty()) {
            this.first = node;
            node.setNext(null);
        }
        else {
            node.setNext(null);
            this.last().setNext(node);
        }
        this.size++;
    }

    public SingleNode<?> getAt(int i) {
        throw new IllegalStateException("Not implemented");
    }

}
