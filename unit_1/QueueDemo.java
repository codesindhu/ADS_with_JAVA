import java.util.LinkedList;
import java.util.*;
public class QueueDemo {
    public static void main(String args[])
    {
        Queue<Object> myqueue=new LinkedList<>();
        
        myqueue.offer("hello");
        myqueue.offer(1);
        myqueue.offer(3);
        myqueue.offer(2);
        myqueue.offer("world");

        while(! myqueue.isEmpty())
        {
            System.out.println(myqueue.poll());
        }
    }
}
