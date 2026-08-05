package Hashtable;

public class Hash {
    //public method that uses hash function to sort the initial array into hash table
    public Node[] sort(Node[] arr){

        Node[] arr2 = new Node[10];

        for(Node n : arr){
            int index = hash(n.element);
            arr2[index] = n;
        }

        return arr2;
    }

    //private method for hash function
    private int hash(String s){
        int x = 0;

        for(int i = 0; i < s.length(); i++){
            int code = s.codePointAt(i);
            x += code;
        }
        return x%10;
    }

    public String contains(Node[] arr, String s){
        int index = hash(s);
        if(arr[index].element == null){
            return "The hashtable does not contain the name: "+s;
        }else{
            if(arr[index].element.equals(s)){
                return "The hashtable contains the name: "+s;
            }else{
                return "The hashtable does not contain the name: "+s;
            }
        }
    }
    
    private void separateChain(){
        //create a linked list from the cell
    }

}
