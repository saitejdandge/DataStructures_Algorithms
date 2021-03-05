package heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class frequency_sort {

    public static void main(String[] args) {

        int a[] = {1, 1, 2, 3, 4, 4, 2, 2, 1, 3, 5, 3, 1, 2, 3, 6};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            if (map.get(i) != null)
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        for (int i : a)
            System.out.print(i + " ");

        System.out.println();
        PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int frequencyDiff = map.get(o2) - map.get(o1);
                return frequencyDiff == 0 ? o1 - o2 : frequencyDiff;
            }
        });

        for (int i : map.keySet()) {
            p.add(i);
        }
        int counter = 0;
        while (!p.isEmpty()) {
            for (int k = 1; k <= map.get(p.peek()); k++) {
                a[counter++] = p.peek();
            }
            p.poll();
        }

        for (int i : a)
            System.out.print(i + " ");
    }

}
