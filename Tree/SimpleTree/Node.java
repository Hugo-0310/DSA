package Tree.SimpleTree;

import java.util.List;
import java.util.ArrayList;

public class Node {
    int element; 
    Node parent;
    List<Node> children = new ArrayList<>();

    public Node(int element){
        this.element = element; 
        this.parent = null;
    }

    public void addChild(Node newChild){
        children.add(newChild);
    }

    public void addParent(Node parent){
        this.parent = parent;
    }

    public Node deleteChild(Node child){
        children.remove(child);
        return  child;
    }
}


