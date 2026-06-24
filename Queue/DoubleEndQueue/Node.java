package Queue.DoubleEndQueue;

public class Node {
    int element; 
    Node nextNode;
    Node prevNode;

    public Node(int element){
        this.element = element;
        this.nextNode = null;
        this.prevNode = null;
    }
}
