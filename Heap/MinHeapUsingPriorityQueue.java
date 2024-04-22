
package minheapusingpriorityqueue;

import java.util.PriorityQueue;

public class MinHeapUsingPriorityQueue
{
    public static void main(String[] args) 
    {
         // your code goes 
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(11);
        heap.add(2);
        heap.add(10);
        heap.add(7);
        heap.add(3);
        heap.add(8);
        System.out.println(heap);
        //[2, 3, 8, 11, 7, 10]
        System.out.println("size of heap : " + heap.size());
        //size of heap : 6
        System.out.println("max in heap : " + heap.peek());
        //min in heap : 2
        System.out.println("Deleted Element: " + heap.poll());
        //Deleted Element: 2
        System.out.println("after deletion");
        System.out.println(heap);
        //[3, 7, 8, 11, 10]
        System.out.println("size of heap : " + heap.size());
        //size of heap : 5
        System.out.println("Deleted Element: " + heap.poll());
        //Deleted Element: 3
        System.out.println(heap);
        //[7, 10, 8, 11]
        System.out.println("max in heap : " + heap.peek());
        //min in heap : 7    
    }
    
}
