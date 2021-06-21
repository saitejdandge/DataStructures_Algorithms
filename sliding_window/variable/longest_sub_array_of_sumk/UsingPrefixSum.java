package sliding_window.variable.longest_sub_array_of_sumk;

import java.util.HashMap;

/*Longest SubArray with given sum (with all numbers)*/
public class UsingPrefixSum {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1}, 5));
    }

    public static int solve(int[] a, int target) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        for (int n : a) {
            prefixSum += n;
            if (map.containsKey(prefixSum - target)) {
                count += map.get(prefixSum - target);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
