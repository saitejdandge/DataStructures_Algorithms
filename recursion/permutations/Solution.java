package recursion.permutations;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    static int count = 0;

    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        //6 places
        int places = 5;
        int[] boxes = new int[places];
        solve(0, a, boxes, new HashMap<>());
        System.out.println(count);
    }

    //choices by items
    public static void solve(int currentItemIndex, int[] a, int[] boxes, HashMap<Integer, Integer> map) {
        if (currentItemIndex == a.length) {
            System.out.println(Arrays.toString(boxes));
            //base case
            count++;
            return;
        }
        int lastOccurrence = map.getOrDefault(a[currentItemIndex], -1);
        for (int i = lastOccurrence + 1; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = a[currentItemIndex];
                map.put(a[currentItemIndex], i);
                solve(currentItemIndex + 1, a, boxes, map);
                map.remove(a[currentItemIndex]);
                boxes[i] = 0;
            }
        }

    }


    //choices by boxes
    public static void solve2(int currentBox, int[] a, boolean[] isItemAvailable, int boxes) {
        if (currentBox == boxes) {
            for (int i = 0; i < a.length; i++) {
                if (isItemAvailable[i])
                    System.out.print(a[i] + " ");
                else
                    System.out.print("_");
            }
            System.out.println();
        }
        //inclusive
        //loop over all the available options
        for (int i = 0; i < a.length; i++) {
            if (isItemAvailable[i]) {
                isItemAvailable[i] = false;
                solve2(currentBox + 1, a, isItemAvailable, boxes);
                isItemAvailable[i] = true;
            }
        }

        //exclusive
        solve2(currentBox + 1, a, isItemAvailable, boxes);

    }

}
