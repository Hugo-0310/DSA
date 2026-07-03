package Tree.BST;

public class Node {
    int element;
    Node parent;
    Node left;
    Node right;

    public Node(int element){
        this.element = element;
        this.parent = this.left =  this.right = null;
    }
}
