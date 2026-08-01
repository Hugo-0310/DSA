package HeapSort;
import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        int[] arr = {3,2,4,5,6,7,1,10,20};

        Maxheap heap = new Maxheap();

        int[] arr2 = heap.heapsort(arr);
        System.out.print(Arrays.toString(arr2));
    }
}
