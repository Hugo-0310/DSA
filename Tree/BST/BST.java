package Tree.BST;

public class BST {

    Node root;
    int size;

    public BST(Node root){
        this.root = root;
    }

    public void insert(Node node){
        //no root
        Node curr = this.root;
        while(! isExternal(curr)){
            if(node.element < curr.element){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        //curr is the external node where the new node will be its child.
        if(curr.element)
    }

    public boolean isExternal(Node node){
        return (node.left == null) & (node.right == null);
    }
    
}
