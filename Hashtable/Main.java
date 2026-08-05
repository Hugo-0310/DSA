package Hashtable;
import java.util.Arrays;

public class Main {
    public static void main(String [] args){

        Hash hash = new Hash();
        
        Node node1 = new Node("AD");
        Node node2 = new Node("BC");
        Node node3 = new Node("Leo");
        Node node4 = new Node("max");
        Node node5 = new Node("CB");
    
        hash.insert(node1);
        hash.insert(node2);
        hash.insert(node3);
        hash.insert(node4);
        hash.insert(node5);

        System.out.println(hash.contains("CB"));
    }
}

