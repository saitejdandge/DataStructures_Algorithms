package dynamic_programming.scrambled_strings;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve("abbbcbaaccacaacc", "acaaaccabcabcbcb"));
    }

    public static boolean solve(String a, String b) {

        if (a.equals(b))
            return true;
        if (a.length() == 1 || b.length() == 1)
            return false;

        int n = a.length();
        for (int i = 1; i <= n - 1; i++) {
            boolean c1 = solve(a.substring(0, i), b.substring(n - i, n));
            boolean c2 = solve(a.substring(i, n), b.substring(0, n - i));

            boolean c3 = solve(a.substring(0, i), b.substring(0, i));
            boolean c4 = solve(a.substring(i, n), b.substring(i, n));

            if ((c1 && c2) || (c3 && c4))
                return true;
        }
        return false;
    }

}