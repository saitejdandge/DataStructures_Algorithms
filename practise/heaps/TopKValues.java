package practise.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopKValues {

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 2, 1, 4, 3, 2, 3, 4, 5, 2, 4, 2, 1};
        int k = 3;
        Arrays.sort(a);
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
        topKMaxValues(a, k);
        System.out.println();
        topKMinValues(a, k);
    }

    public static void topKMaxValues(int[] a, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : a) {
            minHeap.add(i);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        while (!minHeap.isEmpty())
            System.out.print(minHeap.poll() + " ");
    }

    public static void topKMinValues(int[] a, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> j - i);
        for (int i : a) {
            maxHeap.add(i);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        while (!maxHeap.isEmpty())
            System.out.print(maxHeap.poll() + " ");
    }
}
