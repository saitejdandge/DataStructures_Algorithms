package arrays.min_swaps_required_to_sort_array;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{0, 3, 2, 1}));
    }

    public static int solve(int[] a) {

        int n = a.length;
        boolean[] visited = new boolean[n];
        int swapsCount = 0;

        for (int i = 0; i < n; i++) {

            if (i == a[i]) {
                visited[i] = true;

            } else if (!visited[i]) {
                visited[i] = true;
                int next = a[i];
                while (!visited[next]) {
                    visited[next] = true;
                    next = a[next];
                    swapsCount++;
                }


            }
        }
        return swapsCount;
    }
}
