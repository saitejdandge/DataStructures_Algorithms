package heaps;

import java.util.PriorityQueue;

public class connect_ropes_min_cost {

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5 };

        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i : a)
            p.add(i);

        int cost=0;
        while (p.size() > 1) {
            int v1 = p.poll();
            int v2 = p.poll();
            cost+=v1+v2;
            p.add(v1+v2);
        }
        System.out.print(cost);
    }
}
