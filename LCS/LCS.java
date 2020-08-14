package LCS;

public class LCS {

    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        System.out.println(solve(a, b, a.length(), b.length()));
        System.out.println(solveTopDown(a, b));
        System.out.println(solveBottomUp(a, b));

    }

    static int solve(String a, String b, int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        if (a.charAt(m - 1) == b.charAt(n - 1))
            return 1 + solve(a, b, m - 1, n - 1);
        else
            return Math.max(solve(a, b, m, n - 1), solve(a, b, m - 1, n));
    }

    public static int solveTopDown(String a, String b) {
        if (a == null || b == null)
            return 0;

        int[][] t = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++)
            for (int j = 0; j <= b.length(); j++)
                t[i][j] = -1;
        return solveTopDown(a, b, a.length(), b.length(), t);
    }

    private static int solveTopDown(String a, String b, int m, int n, int[][] t) {

        if (m == 0 || n == 0)
            return 0;

        if (t[m][n] != -1)
            return t[m][n];

        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            t[m][n] = 1 + solveTopDown(a, b, m - 1, n - 1, t);
        } else {
            t[m][n] = Math.max(solveTopDown(a, b, m - 1, n, t), solveTopDown(a, b, m, n - 1, t));

        }
        return t[m][n];

    }

    public static int solveBottomUp(String a, String b) {
        if (a == null || b == null)
            return 0;

        int[][] t = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++)
            t[i][0] = 0;
        for (int j = 0; j <= b.length(); j++)
            t[0][j] = 0;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);

            }
        }
        return t[a.length()][b.length()];
    }

}