package Queue.SimipleQ;

public class Main {
    public static void main(String [] args){
        SQ sq = new SQ(5);
        sq.enqueue(1);
        sq.enqueue(2);
        sq.enqueue(3);
        sq.enqueue(4);
        sq.enqueue(5);
        sq.enqueue(6);
        System.out.println(sq.getRear());
        sq.dequeue();
        sq.dequeue();
        sq.dequeue();
        sq.dequeue();
        sq.dequeue();
        System.out.println(sq.getFront());
        sq.dequeue();
        System.out.println(sq.getSize());

    }

}
