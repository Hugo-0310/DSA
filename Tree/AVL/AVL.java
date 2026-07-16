package Tree.AVL;

public class AVL {

    Node root;
    int size;

    public AVL(Node root){
        this.size = 1;
        this.root = root;
    }

    public Node insert(Node newNode){
        return insert(this.root, newNode);
    }
    private Node insert(Node root, Node newNode){
        if(root == null){
            if(this.root == null){
                this.root = newNode;
            }
            this.size += 1;
            return newNode;
        }else{
            if(root.element > newNode.element){
                //make sure to return the root if not changed
                root.left = insert(root.left, newNode);
                if(root.left.height+1 > root.height){
                    root.height += 1;
                }
            }else{
                root.right = insert(root.right, newNode);
                if(root.right.height + 1 > root.height){
                    root.height += 1;
                }
            }
            
            root = applyRotation(root);
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
            //actual deletion happens only here
            root.left = deleteOp(root.left, node);
            //update the height of the root node  
            root.height();
        }else if(root.element < node.element){
            root.right = deleteOp(root.right, node);
            root.height();
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
                successor.left = null;
                successor.right = null;
                successor.height = 0;
            }
        }
        //making sure to return the visited node so that if it's internal node and is not the node we're trying to delete, 
        //we can continue on to go deeper without deleting the current visited node. 
        root = applyRotation(root);
        
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
        if(root.isExternal()){
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

    private Node applyRotation(Node node){
        if(node.balance() > 1){
            if(node.right != null){
                //left-right case
                if(node.right.balance() < 0){
                    node.left = rotateL(node.left); //this swaps the grand child and child. makes it to L-L case.
                }
            }
            //left-left case
            return rotateR(node);
        }else if(node.balance() < -1){
            if(node.left != null){
                //right-left case
                if(node.left.balance() > 0){
                    node.right = rotateR(node.right);
                }
            }
            //right-right case
            return rotateL(node);
        }else{
            return node;
        }
    }

    private Node rotateL(Node node){
        Node rightN = node.right;
        Node middle = rightN.left;
        rightN.left = node;
        if(node.equals(this.root)){
            this.root = rightN;
        }
        node.right = middle;
        if(node.isExternal()){
            node.height = 0;
        }else if(node.left != null & node.right != null){
             node.height = (1+Math.max(node.left.height, node.right.height));
        }else{
            if(node.left != null){
                node.height = node.left.height + 1;
            }else{
                node.height = node.right.height + 1;
            }
        }
        rightN.height = (1+Math.max(rightN.left.height, rightN.right.height));
        return rightN;
    }

    private Node rotateR(Node node){
        Node leftN = node.left;
        Node middle = leftN.right;
        leftN.right = node;
        if(node.equals(this.root)){
            this.root = leftN;
        }
        node.left = middle;
        if(node.isExternal()){
            node.height = 0;
        }else if(node.left != null & node.right != null){
             node.height = (1+Math.max(node.left.height, node.right.height));
        }else{
            if(node.left != null){
                node.height = node.left.height + 1;
            }else{
                node.height = node.right.height + 1;
            }
        }
        leftN.height = (1+Math.max(leftN.left.height, leftN.right.height));
        return leftN;
    }
    
}
