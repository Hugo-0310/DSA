package HeapSort;

public class Maxheap {
    //private method for restoring the heap property within 3 nodes
    private int[] restore(int[] arr, int rootIndex, int tailIndex){
        int left = 2*rootIndex+1;
        int right = 2*rootIndex+2;
        if(left <= tailIndex){
            if(arr[rootIndex] < arr[left]){
                int temp = arr[rootIndex];
                arr[rootIndex] = arr[left];
                arr[left] = temp;
                arr = restore(arr, left, tailIndex);
            }
        }

        if(right <= tailIndex){
            if(arr[rootIndex] < arr[right]){
                int temp = arr[rootIndex];
                arr[rootIndex] = arr[right];
                arr[right] = temp;
                arr = restore(arr, right, tailIndex);
            }
        }
        return arr;    
    }

    //private method to go thru each internal node
    private int[] traverse(int[] arr, int tailIndex){
        //for or while loop? and do restore method each iteration
        int len = arr.length;
        //start from the floored value of len/2 and take 1 from it
        for(int x = len/2; x > 0; x--){
            arr = restore(arr, x-1, tailIndex);
        }

        return arr;
    }

    //private method to swap root and the last element
    private int[] swap(int[] arr, int tailIndex){
        while(tailIndex > 0){
            int temp = arr[tailIndex];
            arr[tailIndex] = arr[0];
            arr[0] = temp;
            arr = traverse(arr, tailIndex-1);
            tailIndex -= 1;
        }
        return arr;
    }

    //public method to just return the final array
    public int[] heapsort(int[] arr){
        arr = traverse(arr, arr.length-1);
        arr = swap(arr, arr.length-1);
        return arr;
    }

}
