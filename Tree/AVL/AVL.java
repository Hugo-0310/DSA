package Tree.AVL;

public class AVL {

    Node root;
    int size;

    public AVL(Node root){
        this.size = 1;
        this.root = root;
    }

    public Node insert(Node root, Node newNode){
        if(root == null){
            if(this.root == null){
                this.root = newNode;
            }
            this.size += 1;
            return newNode;
        }else{
            if(root.element > newNode.element){
                //make sure to return the root.left if not changed
                root.left = insert(root.left, newNode);
            }else{
                root.right = insert(root.right, newNode);
            }
            return root;
        }
    }

    private Node deleteOp(Node root, Node node){
        if(root == null){
            //used when there's no children at all for the parent of this visited node
            return null;
        }
        //comparing the root with the node we want to delete
        if(root.element > node.element){
            //making it to a smaller subproblem
            root.left = deleteOp(root.left, node);
        }else if(root.element < node.element){
            root.right = deleteOp(root.right, node);
        }else{
            //now we found the node we want to delete
            //if we have one or zero child
            if(root.left == null){
                //no left or no child at all
                //if right child exists, then the right child takes place of the deleted node
                //if deleted node doesn't have child, then it'll simply be replaced with null
                return root.right;
            }else if(root.right == null){
                //there was left but no right
                return root.left;
            }else{
                //2 children
                 Node successor = findNext(root);
                 root.element = successor.element;
                 root.right = deleteOp(root.right, successor);
            }
        }
        //making sure to return the visited node so that if it's internal node and is not the node we're trying to delete, 
        //we can continue on to go deeper without deleting the current visited node. 
        return root;
    }

    public void delete(Node node){
        this.root = deleteOp(this.root, node);
        this.size -= 1;
    }
    public Node findNext(Node node){
        //visit the root of the right subtree 
        Node curr = node.right;

        //find the largest of the right subtree by finding the leftmost node. 
        while(curr != null & curr.left != null){
            curr = curr.left;
        }

        return curr;
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
