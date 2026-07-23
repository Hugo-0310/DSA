package Tree.AVL;

public class Node {
    int element;
    Node left;
    Node right;
    int height;

    public Node(int element){
        this.element = element;
        this.left = this.right = null;
        this.height = 0;
    }

    public void height(){
        if(isExternal()){
            this.height = 0;
        }else{
            if(this.left != null & this.right != null){
                if(Math.max(left.height, right.height)+1 < this.height){
                    this.height -= 1;
                }
            }else if(this.left != null){
                if(this.left.height + 1 < this.height){
                    this.height -= 1;
                }
            }else{
                if(this.right.height + 1 < this.height){
                    this.height -= 1;
                }
            }
        }
    }
            

    public int balance(){
        if(isExternal()){
            return 0;
        }else if(this.right != null & this.left != null){
            return this.left.height - this.right.height;
        }else{
            if(this.right != null){
                return -1-this.right.height;
            }else{
                return 1+this.left.height;
            }
        }
    }

    public boolean isExternal(){
        return (this.right == null)&(this.left == null);
    }
}
