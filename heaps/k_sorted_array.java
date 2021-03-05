package heaps;

import java.util.PriorityQueue;

public class k_sorted_array {

    public static void main(String[] args) {

        int a[] = {6, 5, 3, 2, 8, 9, 10};
        int k = 3;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int position = 0;

        for (int i : a) {
            p.add(i);
            if (p.size() > k) {
                a[position++] = p.poll();
            }
        }
        while (!p.isEmpty()) {
            a[position++] = p.poll();
        }
        for (int i : a)
            System.out.print(i + " ");

    }
}
