package ADTS;

/**
 * a stack ADT with basic functionality
 * 
 * @author David Medrano
 */

public class Stack<E> implements StackInterface<E> {
    // data fields
    private Node<E> top = null;
    private Node<E> bottom = null;
    private int size = 0;

    // methods
    @Override
    public void push(Node<E> newElement) {
        if (isEmpty()) { // no elements currently on the stack
            top = newElement; // the top points to the first element that was added
            bottom = newElement; // the bottom points to the first element that was added
            top.setNext(null); // there is only one element, next should point nowhere
            size++; // update the count after adding the first node
        } else { // there are elements already on the stack
            newElement.setNext(top); // the new element now points to the top
            top = bottom; // pass the current top reference to the bottom
            bottom.setNext(null); // bottom should have null next pointer
            top = newElement;
            size++; // update the count
        }

    }

    @Override
    public int pop() {
        if (isEmpty()) { // the stack is empty
            return -1;
        } else if (size == Constants.ONE) { // there is only one element left on the stack
            top = null;
            bottom = null;
            size--;
            return 0;
        } else { // there are elements on the stack
            top = top.getNext();
            size--;
            return 0;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println(Constants.EMPTY_STACK);
            return null;
        } else {
            return this.top.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println(Constants.EMPTY_STACK);
            return;
        } else {
            Node<E> runner = top;
            while (runner != null) {
                System.out.println(runner.getData());
                runner = runner.getNext();
            }
        }
    }
}
