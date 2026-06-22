package Doubly_linked_list;

public class DLL {
    Node head;
    Node tail;
    int size;

    public DLL(Node firstNode){
        this.head = firstNode;
        this.tail = firstNode;
        size = 1;
    }

    //before's
    public Node before(Node location){
        return location.prevNode;
    }

    public void insertBefore(Node location, Node newNode){
        if(location.equals(this.head)){
            location.prevNode = newNode;
            this.head = newNode;
        }else{
            Node temp = location.prevNode;
            location.prevNode = newNode;
            newNode.nextNode = location;
            newNode.prevNode = temp;
        }
        size += 1;
    }
    //after's
    public Node after(Node location){
        return location.nextNode;
    }

    public void insertAfter(Node location, Node newNode){
        if(location.equals(this.tail)){
            location.nextNode = newNode;
            this.tail = newNode;
        }else{
            Node temp = location.nextNode;
            location.nextNode = newNode;
            newNode.prevNode = location;
            newNode.nextNode = temp;
        }
        size += 1;
    }
    //delete
    public void delete(Node location){
        if(this.size == 1){
            //update both head and tail
            this.head = null;
            this.tail = null;
        }else{
            if(location.equals(this.head)){
                this.head = location.nextNode;
                this.head.prevNode = null;
                location.nextNode = null;
            }else if(location.equals(this.tail)){
                this.tail = location.prevNode;
                this.tail.nextNode = null;
                location.prevNode = null;
            }else{
                location.prevNode.nextNode = location.nextNode;
                location.nextNode.prevNode = location.prevNode;
                location.nextNode = null;
                location.prevNode = null;
            }
        }

        this.size -= 1;
    }
    //size
    public int getSize(){
        return 1;
    }
    //traverse
    public String traverse(){
        return null;
    }
}
