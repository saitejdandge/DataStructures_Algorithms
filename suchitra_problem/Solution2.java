package suchitra_problem;

import java.util.HashMap;

public class Solution2 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        max = Integer.MIN_VALUE;
        solve("1111111111111111111111111111111111111111111111111111111111111111111111111111011".toCharArray(), 5, new HashMap<>());
        System.out.println(max);
    }

    public static void solve(char[] a, int k, HashMap<String, Integer> map) {
        max = Math.max(max, getMax(a, map));
        if (k == 0)
            return;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    swap(a, i, j);
                    solve(a, k - 1, map);
                    swap(a, i, j);
                }
            }
        }
    }

    public static int getMax(char[] a, HashMap<String, Integer> map) {
        if (a.length == 1 || a.length == 0)
            return a.length;
        String key = String.valueOf(a);
        if (map.containsKey(key))
            return map.get(key);
        int ans = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int count = 1;
            while (i != a.length - 1 && a[i] == a[i + 1]) {
                i++;
                count++;
            }
            ans = Math.max(ans, count);
        }
        map.put(key, ans);
        return ans;
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
