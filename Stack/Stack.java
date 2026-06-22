package Stack;

public class Stack {
    int[] arr;
    int n = 0;
    int N;
    //create a stack object by specifing the number N for the size of an array. 
    public Stack(int capacity){
        N = capacity;
        arr = new int[N];
    }

    //push
    public void push(int e){
        if(n == N){
            System.out.println("memory overflow error");
        }else{
            arr[n] = e;
            n += 1;
        }
    }
    //pop
    public void pop(){
        if(n == 0){
            System.out.println("no element in stack");
        }else{
            System.out.println("pop: "+arr[n-1]);
            arr[n-1] = 0;
            n -= 1;
        }
    }
    //size

    public void size(){
        System.out.println("size: "+n);
    }

    public void capacity(){
        System.out.println("capacity: "+N);
    }

    //traverse
    public String traverse(int startingIndex){
        //if n == 0, then dont return anything
        if(n==0){
            return null;
        }else{
            if(startingIndex == n-1){
                return String.valueOf(arr[startingIndex]);
            }else{
                return arr[startingIndex] + "-" + traverse(startingIndex+1);
            }
        }
        
    }
}
