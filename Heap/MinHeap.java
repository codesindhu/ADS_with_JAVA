import java.util.*;

class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index) < 
        heap.get(parentIndex)) {
            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && 
        heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && 
        heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != index) {
            Collections.swap(heap, index, smallest);
            heapifyDown(smallest);
        }
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    public int peekMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinHeap minHeap = new MinHeap();

        System.out.println("Enter elements to insert into the Min Heap (enter -1 to stop):");
        int num;
        while ((num = scanner.nextInt()) != -1) {
            minHeap.insert(num);
        }

        System.out.println("Min Heap:");
        while (!minHeap.heap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }

        scanner.close();
    }
}
