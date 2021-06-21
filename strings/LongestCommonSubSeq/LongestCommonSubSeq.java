package strings.LongestCommonSubSeq;

public class LongestCommonSubSeq {

    public static void main(String[] args) {
        String a = "hello";
        String b = "hell";
//        System.out.println(solve(a.length(), b.length(), a, b));
        System.out.println(solve(a, b));
    }

    public static int solve(int m, int n, String a, String b) {
        if (m == 0 || n == 0)
            return 0;
        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            System.out.print(a.charAt(m - 1) + " ");
            return 1 + solve(m - 1, n - 1, a, b);
        } else
            return Math.max(solve(m - 1, n, a, b), solve(m, n - 1, a, b));
    }

    public static int solve(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] t = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                System.out.print(a.charAt(i - 1) + " ");
                i--;
                j--;
            } else if (t[i - 1][j] > t[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return t[m][n];
    }
}
