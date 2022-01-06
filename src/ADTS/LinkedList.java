package ADTS;

/**
 * A doubly linked list of nodes that allows to add, remove, check if it's
 * empty, get sum of (numeric) elements, and display the data of its
 * nodes in chronological order as well as in reverse.
 * 
 * @author David Medrano
 * @see Queue
 * 
 */

public class LinkedList<E> implements LinkedListInterface<E> {
    private Node<E> head;
    private Node<E> tail;
    private Node<E> runner;
    private int size;

    /**
     * Adds a new element to the list. If the node is already present, it creates a
     * copy of it.
     */
    public void add(Node<E> newnode) throws NullPointerException {
        if (head == null && tail == null) { // first item that will be added, this node becomes the head and tail
            head = newnode;
            tail = newnode;
            newnode.setPrevious(null);
            newnode.setNext(null);
            size++;
        } else if (isPresent(newnode)) { // check if the node is already present on the list, makes a copy of it, this node is
                                         // somewhere in the middle (not front nor back)
            Node<E> existingNodeCopy = new Node<>(newnode.getData()); // create a copy of the existing node that will
                                                                      // contain the same data
            add(existingNodeCopy); // recursive call
        } else { // at least one item already exists in the list and this is not the first node
                 // to be added to the list
            head.setPrevious(newnode);
            newnode.setNext(head);
            head = tail;
            newnode.setPrevious(tail);
            tail.setNext(null);
            head = newnode;
            head.setPrevious(null);
            size++;
        }
        
    }

    /**
     * remove by passing a pointer to a node as argument
     * 
     * @return 0 if the node was removed succesfully, otherwise returns -1
     */
    public int remove(Node<E> node) throws NullPointerException {
        runner = head;
        while (runner != null) {
            if (runner == node) {
                if (runner.getPrevious() == null && runner.getNext() == null) { // at this point only this item exists
                    this.clear();
                    return 0;
                } else if (runner.getPrevious() == null && runner == head) { // the item to be deleted is pointing to
                    // the head
                    runner.getNext().setPrevious(null);
                    head = runner.getNext();
                    runner.setNext(null);
                    size--;
                    return 0;
                } else if (runner.getNext() == null && runner == tail) { // the item to be deleted is pointing tail
                    runner.getPrevious().setNext(runner.getNext());
                    tail = runner.getPrevious();
                    runner.setPrevious(null);
                    size--;
                    return 0;
                } else { // item to be deleted is neither the head nor the tail
                    runner.getPrevious().setNext(runner.getNext());
                    runner.getNext().setPrevious(runner.getPrevious());
                    runner.setNext(null);
                    runner.setPrevious(null);
                    size--;
                    return 0;
                } 
                              
            }
            runner = runner.getNext();
        }
        return -1; // at this point no items were removed return error code

    }

    /**
     * remove by passing a arbitrary data as argument. Performs the same task as the
     * function with the same name (declared above).
     * 
     * @return 0 if the node was removed succesfully, otherwise returns -1
     */
    public int remove(E data) throws NullPointerException { // remove by passing data as argument

        runner = head;
        while (runner != null) {

            if (runner.getData().equals(data)) {
                if (runner.getPrevious() == null && tail.getNext() == null) { // at this point only one item exists
                    head = tail = runner = null;
                    size = Constants.ZERO;
                    return 0;
                } else if (runner.getPrevious() == null && runner == head) { // the item to be deleted is pointing to
                                                                             // the head
                    runner.getNext().setPrevious(null);
                    head = runner.getNext();
                    runner.setNext(null);
                    size--;
                    return 0;
                } else if (runner.getNext() == null && runner == tail) { // the item to be deleted is pointing tail
                    runner.getPrevious().setNext(runner.getNext());
                    tail = runner.getPrevious();
                    runner.setPrevious(null);
                    size--;
                    return 0;
                } else { // item to be deleted is neither the head nor the tail
                    runner.getPrevious().setNext(runner.getNext());
                    runner.getNext().setPrevious(runner.getPrevious());
                    runner.setNext(null);
                    runner.setPrevious(null);
                    size--;
                    return 0;
                }
            }
            runner = runner.getNext();
        }
        return -1; // at this point no items were removed
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a node is already present on the list
     * 
     * @param node the pointer to the node that needs to be checked
     * @return true if the node was found, false otherwise
     */
    public boolean isPresent(Node<E> node) {
        runner = head;
        while (runner != null) {
            if (runner == node) {
                return true; // a node was found
            } else {
                runner = runner.getNext(); // keep traversing the list
            }
        }
        return false; // no nodes were found
    }

    /**
     * Displays items in the order in which they were added
     */
    public void display() {
        if (isEmpty()) {
            System.out.println(Constants.EMPTY_LINKED_LIST);
        } else {
            runner = head;
            while (runner != null) {
                System.out.println(runner.getData());
                runner = runner.getNext();
            }
        }
    }

    /**
     * Displays items opposite to the order in which they were added
     */
    public void reverseDisplay() {
        if (isEmpty()) {
            System.out.println(Constants.EMPTY_LINKED_LIST);
        } else {
            runner = tail;
            while (runner != null) {
                System.out.println(runner.getData());
                runner = runner.getPrevious();
            }
        }
    }

    /**
     * Sets all list entry points to null, the nodes in between head and tail
     * remain in memory however.
     */
    public void clear() {
        head = tail = runner = null;
        size = Constants.ZERO;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public Node<E> getRunner() {
        return runner;
    }

    public void setRunner(Node<E> runner) {
        this.runner = runner;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
