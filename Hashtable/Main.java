package Hashtable;
import java.util.Arrays;

public class Main {
    public static void main(String [] args){

        Hash hash = new Hash();
        
        Node node1 = new Node("Hugo");
        Node node2 = new Node("Max");
        Node node3 = new Node("Leo");

        Node[] names = {node1, node2, node3};
        Node[] names2 = hash.sort(names);

        System.out.println(Arrays.toString(names2));
        System.out.println(hash.contains(names2, "Hugo"));
    }
}

