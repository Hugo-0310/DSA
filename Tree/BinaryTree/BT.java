package Tree.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;

public class BT{
    private Node root;
    private int size;

    public BT(Node root){
        this.root = root;
        this.size = 1;
    }

    public void addLeft(Node parent, Node child){
        parent.addLeft(child);
        child.addParent(parent);
        this.size += 1;
    }

    public void addRight(Node parent, Node child){
        parent.addRight(child);
        child.addParent(parent);
        this.size += 1;
    }

    public Node delete(Node node){
        
        if(node.isExternal()){
        //if external
            //if root
            if(node.isRoot()){
                this.root = null;
                this.size = 0;
            }else{
            //if not root
                if(node.equals(node.getParent().getLeft())){
                    //node is the left child
                    node.getParent().deleteLeft();
                }else{
                    //node is the right child
                    node.getParent().deleteRight();
                }
                node.deleteParent();
            }
        //if internal
        }else{
            //we replace the node with right most node. 
            Node rightmost = getRightMostExt(this.root);
            rightmost.addParent(node.getParent());
            rightmost.addLeft(node.getLeft());
            rightmost.addRight(node.getRight());
            node.deleteLeft();
            node.deleteRight();
            node.deleteParent();
        }
        this.size -= 1;
        return node;
    }

    public int getSize(){
        return this.size;
    }

    public Node getRoot(){
        return this.root;
    }

    public Node getRightMostExt(Node root){
        //must be the rightmost of all external
        if(root.isExternal()){
            return root;
        }else{
            if(root.getRight()!= null){
                return getRightMostExt(root.getRight());
            }else{
                return getRightMostExt(root.getLeft());
            }
        }
    }   
}
