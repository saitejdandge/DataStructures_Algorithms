package strings.LongestCommonSubString;

public class LongestCommonSubString {
    public static void main(String[] args) {

        String a = "abcaaaaaaaa";
        String b = "abcaa";
        System.out.println(solve(a.length(), b.length(), a, b, 0));
    }

    public static int solve(int m, int n, String a, String b, int count) {
        if (m == 0 || n == 0)
            return count;
        if (a.charAt(m - 1) == b.charAt(n - 1))
            count = Math.max(count, solve(m - 1, n - 1, a, b, count + 1));
        else
            count = Math.max(count, Math.max(solve(m - 1, n, a, b, 0), solve(m, n - 1, a, b, 0)));
        return count;
    }
}
