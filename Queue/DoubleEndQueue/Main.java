package Queue.DoubleEndQueue;

public class Main {
    public static void main(String [] args){
    
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    DQ dq = new DQ(node1);
    dq.insertRear(node2);
    dq.insertRear(node3);
    dq.insertRear(node4);

    dq.deleteFront();
    dq.deleteRear();

    System.out.println(dq.getFront().element);
    System.out.println(dq.getRear().element);

    System.out.println("Size: " + dq.getSize());
    System.out.println(dq.isEmpty());

    System.out.println(dq.traverse(node2));

    }
}
