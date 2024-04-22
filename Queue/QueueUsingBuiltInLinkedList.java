package queueusingbuiltinlinkedlist;

import java.util.LinkedList;

class LinkedQueue {

    private LinkedList queue = new LinkedList<>();

    public void enqueue(int item) {
        queue.addLast(item);

    }

    public int dequeue() {
        return (int) queue.removeFirst();

    }

    public void print() {
        System.out.println(queue);
    }

}

public class QueueUsingBuiltInLinkedList {

    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.enqueue(10);
        lq.enqueue(20);
        lq.enqueue(30);
        lq.print();
        lq.dequeue();
        lq.print();
        lq.enqueue(40);
        lq.print();
        lq.dequeue();
        lq.print();
    }

}
