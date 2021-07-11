package amazon.Choclate.shopping;

import java.util.HashMap;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

        System.out.println(solve(new int[][]{{10000}, {2, 3, 4}, {3, 2}, {1, 6}}, 0, 10, "", new HashMap<>()));

        System.out.println(solve2(new int[]{2, 3}, new int[]{4}, new int[]{3, 2}, new int[]{1, 2}, 10));
    }


    public static int solve2(int[] a, int[] b, int[] c, int[] d, int budget) {

        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        //frequency map for array d
        for (int r : c)
            for (int s : d) {
                hashMap.put(s + r, hashMap.getOrDefault(s + r, 0) + 1);
            }
        int count = 0;
        for (int p : a) {
            for (int q : b) {
                //p+q+r+s=budget
                //..do your thing here
                //all keys less that of given value
                if (budget - (p + q) >= 0) {
                    count += hashMap.headMap(budget - (p + q)).size();
                    count += hashMap.getOrDefault(budget - (p + q), 0);
                }
            }
        }
        return count;
    }

    public static int solve(int[][] a, int i, int budget, String res, HashMap<String, Integer> map) {
        if (i == a.length) {
            System.out.println(res);
            return 1;
        }

        if (map.containsKey(i + ":" + budget)) {
            return map.get(i + ":" + budget);
        }
        if (budget <= 0)
            return 0;

        int ans = 0;
        for (int j = 0; j < a[i].length; j++) {
            if (a[i][j] <= budget)
                ans += solve(a, i + 1, budget - a[i][j], res + " " + a[i][j], map);
        }
        map.put(i + ":" + budget, ans);
        return ans;
    }
}
