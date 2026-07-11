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

    public Node delete(Node node){
        if(isExternal(node)){
            if(node.parent.left.equals(node)){
                node.parent.left = null;
            }else{
                node.parent.right = null;
            }
            node.parent = null;
            this.size -= 1;
        }else{
            //if internal
            
        }
        return node;
    }

    public String inorder(Node root){
        if(isExternal(root)){
            return String.valueOf(root.element);
        }else{
            if(root.left != null & root.right != null){
                return inorder(root.left)+"-"+String.valueOf(root.element)+"-"+inorder(root.right);
            }else{
                if(root.left != null){
                    return inorder(root.left)+"-"+String.valueOf(root.element);
                }else{
                    return String.valueOf(root.element)+"-"+inorder(root.right);
                }
            }
        }
    }


    public boolean isExternal(Node node){
        return (node.left == null) & (node.right == null);
    }
    
}
