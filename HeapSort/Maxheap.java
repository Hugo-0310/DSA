package HeapSort;

public class Maxheap {
    //private method for restoring the heap property within 3 nodes
    private int[] restore(int[] arr, int rootIndex){
        int left = 2*rootIndex+1;
        int right = 2*rootIndex+2;
        if(left < arr.length){
            if(arr[rootIndex] < arr[left]){
                int temp = arr[rootIndex];
                arr[rootIndex] = arr[left];
                arr[left] = temp;
                arr = restore(arr, left);
            }
        }

        if(right < arr.length){
            if(arr[rootIndex] < arr[right]){
                int temp = arr[rootIndex];
                arr[rootIndex] = arr[right];
                arr[right] = temp;
                arr = restore(arr, right);
            }
        }
        return arr;    
    }

    //private method to go thru each internal node
    private int[] traverse(int[] arr){
        //for or while loop? and do restore method each iteration
        int len = arr.length;
        //start from the floored value of len/2 and take 1 from it
        for(int x = len/2; x > 0; x--){
            arr = restore(arr, x-1);
        }

        return arr;
    }

    //private method to swap root and the last element

    //public method to just return the final array
    public int[] heapsort(int[] arr){
        arr = traverse(arr);
        return arr;
    }

}
