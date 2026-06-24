package Queue.DoubleEndQueue;

public class DQ {
    Node front;
    Node rear;
    int size;

    public DQ(Node firstNode){
        this.front = firstNode;
        this.rear = firstNode;
        this.size = 1;
    }

    //front
    public Node getFront(){
        return this.front;
    }

    public void insertFront(Node newNode){
        if(size ==0 ){
            this.front = newNode;
            this.rear = newNode;
            this.size = 1;
        }else{
            newNode.nextNode = this.front;
            this.front.prevNode = newNode;
            this.front = newNode;
            size += 1;
        }
    }

    public void deleteFront(){
        if(this.size == 0){
           System.out.println("no element in the queue");
        }else{
            Node temp = this.front;
            this.front = this.front.nextNode;
            this.front.prevNode = null;
            temp.nextNode = null;
            this.size -= 1;
            System.out.println("Deleted: " + temp.element);
        }
    }

    //rear
    public Node getRear(){
        return this.rear;
    }

    public void insertRear(Node newNode){
        if(this.size == 0){
            this.rear = newNode;
            this.front = newNode;
            this.size = 1;
        }else{
            newNode.prevNode = this.rear;
            this.rear.nextNode = newNode;
            this.rear = newNode;
            this.size += 1;
        }
    }

    public void deleteRear(){
        if(this.size == 0){
            System.out.println("no element in the queue");
        }else{
            Node temp = this.rear;
            this.rear = this.rear.prevNode;
            this.rear.nextNode = null;
            temp.prevNode = null;
            this.size -= 1;
            System.out.println("Deleted: " + temp.element);
        }
    }

    //size
    public int getSize(){
        return this.size;
    }

    //isEmpty
    public boolean isEmpty(){
        return this.size == 0;
    }

    public String traverse(Node startNode){
        if(this.rear.equals(startNode)){
            return String.valueOf(this.rear.element);
        }
        return String.valueOf(startNode.element)+"-"+traverse(startNode.nextNode);
    }

}
