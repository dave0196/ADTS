import ADTS.*;

public class Main {
    public static void main(String args[]) {
        LinkedList<Number> l = new LinkedList<>();
        Node<Number> n0 = new Node<>(56.0);
        Node<Number> n1 = new Node<>(5);

        System.out.println(l.isPresent(n1));
        l.add(n0);
        l.add(n1);
        l.display();  
        System.out.println(l.isPresent(n1));
                   
    }
}
