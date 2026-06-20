package SinglyLinkedList;

public class Main {
    public static void main(String [] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        SLL sll = new SLL(node2);
        sll.insertBefore(node2, node1);
        sll.insertAfter(node2, node3);
        sll.insertAfter(node3, node4);
        sll.traverse();
        sll.delete(node4);
        System.out.println(sll.traverse_1(node1));
    }
}

