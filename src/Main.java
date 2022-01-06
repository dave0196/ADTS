import ADTS.*;

public class Main {
    public static void main(String args[]) {
        LinkedList<Number> l = new LinkedList<>();
        Queue<Number> q = new Queue<>();
        // add nodes
        Node<Number> n0 = new Node<>(56.0);
        Node<Number> n1 = new Node<>(5);
        Node<Number> n2 = new Node<>(3.34);
        Node<Number> n3 = new Node<>(4);

        q.enqueue(n1);
        q.enqueue(n1);
        q.enqueue(n1);
        System.out.println(q.size());
        q.dequeue();
        q.dequeue();

        System.out.println(q.getFront());
    }
}
