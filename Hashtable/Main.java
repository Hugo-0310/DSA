package Hashtable;
import java.util.Arrays;

public class Main {
    public static void main(String [] args){

        Hash hash = new Hash();
        
        String[] names = {"hugo", "leo", "max"};

        String[] names2 = hash.sort(names);

        System.out.println(Arrays.toString(names2));
        System.out.println(hash.contains(names2, "huo"));
    }
}
