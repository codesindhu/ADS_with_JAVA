import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class PriorityQueueDemo
{
    public static void main(String args[])
    {
        Queue<Integer> pqueue=new PriorityQueue<>();
           Scanner sc=new Scanner(System.in);
        System.out.println("enter no of elements you want to insert");
        int a=sc.nextInt();
        System.out.println("enter elements");
        for(int i=0;i<=a;i++)
        {
            pqueue.offer(sc.nextInt());
        }
        


        System.out.println(" elements in priority queue :");
        while(! pqueue.isEmpty())
        {
            System.out.println(pqueue.poll());
        }
    }
}