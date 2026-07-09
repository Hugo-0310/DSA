package Tree.BST;

public class BST {

    Node root;
    int size;

    public BST(Node root){
        this.root = root;
    }

    public Node insert(Node root, Node newNode){
        if(root == null){
            this.size += 1;
            return newNode;
        }else{
            if(root.element > newNode.element){
                //make sure to return the root.left if not changed
                root.left = insert(root.left, newNode);
                root.left.parent = root;
            }else{
                root.right = insert(root.right, newNode);
                root.right.parent = root;
            }
            return root;
        }
    }


    public boolean isExternal(Node node){
        return (node.left == null) & (node.right == null);
    }
    
}
