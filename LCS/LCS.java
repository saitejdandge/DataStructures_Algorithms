package LCS;
public class LCS {
    public static void main(String[] args) {
        String a = "abcdefghijkl";
        String b = "cxeihpjkl";
        System.out.println(solve(a, b, a.length(), b.length()));
    }

    static int solve(String a, String b, int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        if (a.charAt(m - 1) == b.charAt(n - 1))
            return 1 + solve(a, b, m - 1, n - 1);
        else
            return Math.max(solve(a, b, m, n - 1), solve(a, b, m - 1, n));
    }
}