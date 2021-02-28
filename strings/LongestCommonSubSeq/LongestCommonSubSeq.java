package strings.LongestCommonSubSeq;

public class LongestCommonSubSeq {

    public static void main(String[] args) {
        String a = "banana";
        String b = "baa";
        System.out.println(solve(a.length(), b.length(), a, b));
    }

    public static int solve(int m, int n, String a, String b) {
        if (m == 0 || n == 0)
            return 0;
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return 1 + solve(m - 1, n - 1, a, b);
        else
            return Math.max(solve(m - 1, n, a, b), solve(m, n - 1, a, b));
    }
}
