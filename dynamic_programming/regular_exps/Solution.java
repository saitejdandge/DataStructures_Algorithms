package dynamic_programming.regular_exps;

public class Solution {
    public static void main(String[] args) {

        String s = "aaa";
        String p = ".*";
        System.out.println(solve(s, p, s.length(), p.length()));
    }

    public static boolean solve(String s, String p, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        if (m < 0 || n < 0)
            return false;

        if (p.charAt(n - 1) == '*') {
            char v = p.charAt(n - 2);

            int x = m - 1;
            while (x >= 0 && (v == '.' || v == s.charAt(x))) {
                x--;
            }
            System.out.println(x);
            return solve(s, p, x + 1, n - 2);
        } else {

            if (p.charAt(n - 1) == '.' || p.charAt(n - 1) == s.charAt(m - 1))
                return solve(s, p, m - 1, n - 1);
            else
                return false;
        }

    }
}
