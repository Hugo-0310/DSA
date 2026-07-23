package Tree.AVL;

public class Main {
    public static void main(String [] args){
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        AVL avl = new AVL(node4);
        avl.insert(node3);
        avl.insert(node2);
        avl.insert(node1);
        avl.insert(node5);
        avl.insert(node6);
        avl.insert(node8);
        System.out.println("delete");
        avl.delete(node4);
        System.out.println(avl.root.element);
        avl.inorder();

    }
}
