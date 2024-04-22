import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
public class ComparatorDemo {
    public static void main(String args[])
    {

        Comparator<String> comparStringLength=Comparator.comparing(String::length);
        Queue<String> pqueue= new PriorityQueue<>(comparStringLength);
        

        pqueue.offer("employee");
        pqueue.offer("worker");
        pqueue.offer("student");
        System.out.println(pqueue);
        System.out.println("The peek value in the priorityQueue is: " +pqueue.peek());
        while(!pqueue.isEmpty())
        {
            System.out.println(pqueue.poll());
        }
    }
}
