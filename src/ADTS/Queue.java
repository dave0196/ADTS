package ADTS;

/**
 * A Queue ADT implementation that uses a doubly linked list of nodes
 * 
 * @author David Medrano
 * @see LinkedList
 * 
 */

public class Queue<E> implements QueueInterface<E> {

    private Node<E> front;
    private Node<E> back;
    private LinkedList<E> list;
    
    // constructor
    public Queue() {
        front = back = null;
        list = new LinkedList<E>();
    }

    /**
     * Add an element to the back of the queue
     * 
     * @param element a pointer to the node that will be added to the list
     * @throws NullPointerException
     */
    public void enqueue(Node<E> element) throws NullPointerException {
        if (front == null && back == null) { // add the an element for the first time
            list.add(element);
            front = list.getTail(); // make front point to the tail of the list
            back = list.getHead(); // make the back point to the head of the list
        } else { // there are elements present on the list
            back = element;
            list.add(element);
        }
    }

    /**
     * Remove the element that was first added to the queue
     * 
     * @return the data of the node that was first added to the queue, null if there
     *         are no elements to be removed
     * @throws NullPointerException
     */
    public E dequeue() throws NullPointerException { // REMOVE BY SPECIFYING A NODE
        if (isEmpty()) { // queue is empty
            System.out.println("queue is empty");
            return null;
        } else if (list.getSize() == Constants.ONE) { // only one item exists on the queue, set the front and back to null
            front = back = null;
            list.setSize(list.getSize() - Constants.ONE); // decrement size of the by one
            return list.getHead().getData();
        } else { // queue is not empty, remove the item from the somewhere in the middle
            front = front.getPrevious(); // make front point to the previous node in the list
            list.setTail(front.getNext()); // make the list.getTail() point to the next node the front is pointing to
            list.setSize(list.getSize() - Constants.ONE); // decrement size of the by one
            return list.getTail().getData();
        }
    }

    /**
     * @return true if the queue is currently empty
     */
    public boolean isEmpty() {
        return (front == null && back == null);
    }
 
    public int size() {
        return list.size();
    }

    /**
     * sets front and back to null, preventing further access whichever elements may lie between.
     */
    public void clear() {
        front = back = null;
        list.clear();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println(Constants.EMPTY_QUEUE);
            return;
        } else {
            list.setRunner(front);
            while (list.getRunner() != null) {
                System.out.println(list.getRunner().getData());
                list.setRunner(list.getRunner().getPrevious());
            }
        }
    }

    public void reverseDisplay() {
        list.setRunner(back);
        while (list.getRunner() != null) {
            System.out.println(list.getRunner().getData());
            list.setRunner(list.getRunner().getNext());
        }
    }

}
