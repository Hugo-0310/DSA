package Tree.BinaryTree;

public class Node {
    private int element;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int element){
        this.element = element;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public int getElement(){
        return this.element;
    }

    public Node getParent(){
        return this.parent;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }
    public void addLeft(Node left){
        this.left = left;
    }

    public void addRight(Node right){
        this.right = right;
    }

    public void addParent(Node parent){
        this.parent = parent;
    }

    public Node deleteParent(){
        Node temp = this.parent;
        this.parent = null;
        return temp;
    }

    public Node deleteLeft(){
        Node temp = this.left;
        this.left = null;
        return temp;
    }

    public Node deleteRight(){
        Node temp = this.right;
        this.right = null;
        return temp;
    }


    public boolean isExternal(){
        return (this.left==null) & (this.right == null);
    }

    public boolean isRoot(){
        return this.parent == null;
    }
}
