package ADTS;

public interface QueueInterface<E> {

    void enqueue(Node<E> element);

    E dequeue();

    boolean isEmpty();

}
