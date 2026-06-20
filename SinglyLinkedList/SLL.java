package SinglyLinkedList;

public class SLL{

    int size;
    Node head;
    Node tail;

    public SLL(Node firstNode){
        size = 1;
        this.head = firstNode;
        this.tail = firstNode;
    }

    public void insertBefore(Node location, Node theNode){
        size += 1;
        //we can use while loop here. update the input to the nextNode until it hits the loation.
        
        Node curr_node = this.head;
        //base case -> head is the location, thus insert before the head Node
        if(curr_node.equals(location)){
            //connect the new node and the previous head node
            theNode.nextNode = location;
            //update the head Node
            this.head = theNode;
        }else{
            boolean notFound = true;
            while(notFound || curr_node.nextNode != null){
                //check if the nextNode is the location
                if(curr_node.nextNode.equals(location)){
                    //new node will be the next node of the curr node
                    curr_node.nextNode = theNode;
                    //previous next node will be the new node's next node
                    theNode.nextNode = location;
                    notFound = false;
                }else{
                    curr_node = curr_node.nextNode;
                }
                //update the current node if not
            }
        }
        
    }
    
    public void insertAfter(Node location, Node theNode){
        size += 1;
        if(location.nextNode == null){
            location.nextNode = theNode;
            this.tail = theNode;
        }else{
            Node temp = location.nextNode;
            location.nextNode = theNode;
            theNode.nextNode = temp;
        }
    }

    public void insertTail(Node newTail){
        insertAfter(this.tail, newTail);
        size += 1;
    }

    public void insertHead(Node newHead){
        insertBefore(this.head, newHead);
        size += 1;
    }

    public void delete(Node theNode){
        //delete -> break the connection between the one before and after. 
        //Caution: update head and tail flag if needed
        if(this.size == 1){
            //the node is both head and tail.
            this.head = null;
            this.tail = null;
        }else{
            //if head
            if(theNode.equals(this.head)){
                this.head = theNode.nextNode;
                theNode.nextNode = null;
            }else{
                //traverse until the nextNode is the tail
                Node curr_node = this.head;
                boolean notFound = true;
                //once done, the curr_node will be the one before the tail.
                while(notFound & curr_node.nextNode != null){
                    if(curr_node.nextNode.equals(theNode)){
                        notFound = false;
                    }else{
                        curr_node = curr_node.nextNode;
                    }
                }
                //if it's tail
                if(this.tail.equals(theNode)){
                    curr_node.nextNode = null;
                    this.tail = curr_node;
                }else{
                //if it's somewhere in the middle
                    curr_node.nextNode = theNode.nextNode;
                    theNode.nextNode = null;
                }
                
            }
        }
        size -= 1;
    }

    public void traverse(){
        Node curr_node = this.head;
 
        while(curr_node != null){
            System.out.print(curr_node.element);
            curr_node = curr_node.nextNode;
        }
    }

    public String traverse_1(Node startNode){
        if(startNode.nextNode == null){
            String ele = String.valueOf(startNode.element);
            return ele;
        }else{
            int ele = startNode.element;
            startNode = startNode.nextNode;
            return ele+"-"+traverse_1(startNode);
        }
    }
}