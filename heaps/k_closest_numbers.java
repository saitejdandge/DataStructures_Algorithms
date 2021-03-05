package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class k_closest_numbers {

    public static void main(String[] args) {

        int a[] = {5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;
        PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(o1 - x) - Math.abs(o2 - x));
            }

            ;
        });
        for (int i : a)
            p.add(i);

        while (!p.isEmpty() && k > 0) {
            System.out.print(p.poll() + " ");
            k--;
        }
    }
}
