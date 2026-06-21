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
        
    }
    //after's
    public Node after(Node location){
        return location.nextNode;
    }

    public void insertAfter(Node location, Node newNode){

    }
    //delete
    public void delete(Node location){}
    //size
    public int getSize(){
        return 1;
    }
    //traverse
    public String traverse(){
        return null;
    }
}
