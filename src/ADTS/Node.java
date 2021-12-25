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
    private int occurs; // the number of times the node has been added to the list

    // constructor
    public Node(E data) {
        this.data = data;
        previous = null;
        next = null;
        occurs = Constants.ONE; // the node has been created once, therefore its occurs value should be one
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

    public int getOccurs() {
        return occurs;
    }

    public void setOccurs(int occurs) {
        this.occurs = occurs;
    }

    @Override
    public String toString() {
        return String.format("Data: %s", this.data);
    }

}
