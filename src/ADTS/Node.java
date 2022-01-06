package ADTS;

/**
 * Node class that can be inplemented used in a doubly linked list, a stack, or a
 * queue.
 * 
 * @author David Medrano
 * @see Linked List, Stack, Queue
 */
public class Node<E> {
    private E data;
    private Node<E> previous;
    private Node<E> next;

    // constructor
    public Node(E data) {
        this.data = data;
        previous = null;
        next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("Data: %s", this.data);
    }

}
