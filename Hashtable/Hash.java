package Hashtable;

public class Hash {
    //public method that uses hash function to sort the initial array into hash table
    public String[] sort(String[] arr){

        String[] arr2 = new String[10];

        for(String s : arr){
            int index = hash(s);
            arr2[index] = s;
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

        System.out.println(s+"'s hashcode is: "+x%10);
        return x%10;
    }


}
