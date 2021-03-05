package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class k_smallest {

    public static void main(String[] args) {

        int k = 3;
        int a[] = {7, 10, 4, 3, 20, 15};

        PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

            ;
        });

        for (int i : a) {
            p.add(i);
            if (p.size() > k)
                p.poll();
        }
        System.out.print(p.peek());
    }

}
