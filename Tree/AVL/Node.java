package Tree.AVL;

public class Node {
    int element;
    Node left;
    Node right;

    public Node(int element){
        this.element = element;
        this.left = this.right = null;
    }

    public int height(){
        if(isExternal()){
            return 0;
        }else if(this.right != null & this.left != null){
            return 1 + Math.max(this.right.height(), this.left.height());
        }else{
            if(this.right != null){
                return 1 + this.right.height();
            }else{
                return 1 + this.left.height();
            }
        }
    }

    public boolean isExternal(){
        return (this.right == null)&(this.left == null);
    }
}
