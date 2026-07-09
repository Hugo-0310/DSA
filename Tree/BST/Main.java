package Tree.BST;

public class Main {
    public static void main(String[]args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        BST bst = new BST(node1);
        bst.insert(node1, node2);
        bst.insert(node1, node3);
        bst.insert(node1, node4);
        bst.insert(node1, node5);

        System.out.println(node3.parent.element);
    }
}
