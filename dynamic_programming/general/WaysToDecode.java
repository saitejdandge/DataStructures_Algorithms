package dynamic_programming.general;

import java.util.Arrays;

public class WaysToDecode {
    int[] map;

    public static void main(String[] args) {
        System.out.println(new WaysToDecode().numDecodings("12132123216262162612525124152616262626173739273273211122113"));
    }

    public int numDecodings(String a) {
        if (a == null || a.length() == 0)
            return 0;
        else {
            map = new int[a.length()];
            Arrays.fill(map, -1);
            return solve(a.toCharArray(), 0);
        }
    }

    public int solve(char[] a, int pos) {
        if (pos == a.length) {
            return 1;
        }
        if (a[pos] == '0')
            return 0;
        if (map[pos] != -1)
            return map[pos];
        int res = solve(a, pos + 1);
        if (pos + 1 < a.length && (a[pos] == '1' || (a[pos] == '2' && a[pos + 1] <= '6')))
            res += solve(a, pos + 2);
        map[pos] = res;
        return res;
    }
}