package Doubly_linked_list;

public class Main {
    public static void main(String [] args){
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    
    DLL dll = new DLL(node1);
    dll.insertAfter(node1, node3);
    dll.insertBefore(node3, node2);
    dll.insertAfter(node3, node4);
    System.out.println(dll.before(node3));
    System.out.println(dll.traverse(node1));
    }
}
