package Queue.SimipleQ;

public class SQ <t>{
    int N; //array capacity
    int n; //queue size/next available cell's index
    int[] arr;
    int front;

    public SQ(int capacity){
        if(capacity > 0){
            this.N = capacity;
            arr = new int[this.N];
            this.n = 0;
        }else{
            System.out.println("It has to be a positive integer");
        }
    }

    public void enqueue(int e){
        if(n==N){
            System.out.println("queue out of memory");
        }else{
            arr[n] = e;
            n += 1;       
        }
    }

    public String getFront(){
        if(isEmpty()){
            return "queue is empty";
        }
        return "Front: "+String.valueOf(arr[0]);
    }

    public void dequeue(){
        if(n==0){
            System.out.println("no element in the queue"); 
        }else if(n==1){
            System.out.println(arr[0]);
            arr[0] = 0;
            n -= 1;
        }else{
            System.out.println(arr[0]);
            for(int i = 1; i < n; i++){
                arr[i-1] = arr[i];
                arr[i] = 0;
            }
            n -= 1;
        }
    }

    public String getRear(){
        if(isEmpty()){
            return "queue is empty";
        }
        return "Rear: " + String.valueOf(arr[n-1]);
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public boolean isFull(){
        return n==N;
    }

    public String getSize(){
        if(isEmpty()){
            return "Size: 0";
        }
        return "Size: " + String.valueOf(n);
    }

}
