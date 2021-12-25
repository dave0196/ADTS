package ADTS;

public interface LinkedListInterface <E> {
    
    void add(Node<E> node);

    int remove(Node<E> node);

    int remove(E data);

    int size();

    boolean isEmpty();

    void display();

    void reverseDisplay();

    void clear();
}
