package heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class k_freq_numbers {

    public static void main(String[] args) {
        int k = 3;
        int a[] = {1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 4, 4};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            if (map.get(i) != null)
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        PriorityQueue<Integer> p = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int f1 = map.get(o1);
                int f2 = map.get(o2);
                return f1 - f2;
            }
        });

        int prev = -1;
        for (int i : a) {
            if (i == prev)
                continue;
            p.add(i);
            if (p.size() > k)
                p.poll();
            prev = i;
        }
        while (!p.isEmpty()) {
            System.out.print(p.poll() + " ");
        }
    }
}
