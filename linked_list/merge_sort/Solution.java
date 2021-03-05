package linked_list.merge_sort;

import linked_list.implemenation.LinkedList;

import java.util.Comparator;

public class Solution {


    public static void main(String[] args) {
        LinkedList<Double> x = new LinkedList<>();
        x.addFirst(1.11);
        x.addLast(4.3);
        x.addLast(-2.3);
        x.addLast(1.111);


        x.sort();

        x.sort(new Comparator<>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o2 > o1)
                    return 1;
                else
                    return 0;
            }
        });
        for (Double xy : x)
            System.out.println(xy);


    }
}
