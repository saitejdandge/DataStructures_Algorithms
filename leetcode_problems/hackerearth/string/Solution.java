package leetcode_problems.hackerearth.string;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        int c[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        String s = "aab";
        System.out.print(solve(s, 0, c));
    }

    public static boolean check(int i, int j, String s, int[] c) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int k = i; k <= j; k++) {
            if (map.get(s.charAt(k)) != null)
                map.put(s.charAt(k), map.get(s.charAt(k)) + 1);
            else
                map.put(s.charAt(k), 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() > c[e.getKey() - 97]) {
                System.out.println(s.substring(i, j + 1) + " true");
                return false;
            }
        }

        System.out.println(s.substring(i, j + 1) + " false");
        return true;

    }

    public static int solve(String s, int n, int c[]) {
        if (n == s.length())
            return 1;

        int sum = 0;
        if (check(0, n, s, c)) {
            sum = sum + solve(s, n + 1, c);
        }
        return sum;

    }
}
