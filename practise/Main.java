package practise;

import practise.heaps.Heap;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(10);
        for (int i = 0; i < 1000; i++)
            heap.add(i);
        heap.printHeap();
    }
}
