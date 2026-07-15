package Tree.AVL;

public class Main {
    public static void main(String [] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        AVL avl = new AVL(node4);
        avl.insert(node4, node6);
        avl.insert(node4, node3);
        avl.insert(node4, node7);
        avl.insert(node4, node5);
        avl.insert(node4, node2);
        avl.insert(node4, node1);

        System.out.println(node6.balance());

    }
}
