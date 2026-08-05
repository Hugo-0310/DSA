package Hashtable;

public class Hash {

    Node[] arr = new Node[10];
   
    //public method that uses hash function to sort the initial array into hash table
    // public Node[] sort(Node[] arr){

    //     Node[] arr2 = new Node[10];

    //     for(Node n : arr){
    //         int index = hash(n.element);
    //         arr2[index] = n;
    //     }

    //     return arr2;
    // }

    //private method for hash function
    private int hash(String s){
        int x = 0;

        for(int i = 0; i < s.length(); i++){
            int code = s.codePointAt(i);
            x += code;
        }
        return x%10;
    }

    public void insert(Node node){
        int index = hash(node.element);
        if(arr[index]==null){
            arr[index] = node;
        }else{
            separateChain(arr[index], node);
        }
    }

    public String contains(String s){
        int index = hash(s);
        if(arr[index].element == null){
            return "The hashtable does not contain the name: "+s;
        }else{
            if(arr[index].element.equals(s)){
                return "The hashtable contains the name: "+s;
            }else{
                //go thru the linked list here
                Node curr = arr[index];
                while(curr.next != null){
                    if(curr.next.element.equals(s)){
                        return "The hashtable contains the name: "+s;
                    }
                    curr = curr.next;
                }
                return "The hashtable does not contain the name: "+s;
            }
        }
    }
    
    private void separateChain(Node curr, Node newNode){
        //create a linked list from the cell
        if(curr.next == null){
            curr.next = newNode;
        }else{
            separateChain(curr.next, newNode);
        }
    }



}
