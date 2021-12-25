package ADTS;

public interface StackInterface<E> {

   boolean isEmpty();

   void push(Node<E> newElement);

   int pop();

   void display();

   E peek();

   int size();

}
