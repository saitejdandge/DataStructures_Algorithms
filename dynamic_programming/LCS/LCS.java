package dynamic_programming.LCS;

public class LCS {

    public static void main(String[] args) {
        String a = "GEEK";
        String b = "EKE";
        // System.out.println(solve(a, b, a.length(), b.length()));
//        System.out.println(solveTopDown(a, b));
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
        return solveTopDown(a, b, a.length(), b.length(), t, new StringBuilder());
    }

    private static int solveTopDown(String a, String b, int m, int n, int[][] t, StringBuilder stringBuilder) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (t[m][n] != -1)
            return t[m][n];

        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            stringBuilder.append(a.charAt(m - 1));
            t[m][n] = 1 + solveTopDown(a, b, m - 1, n - 1, t, stringBuilder);
        } else {
            t[m][n] = Math.max(solveTopDown(a, b, m - 1, n, t, stringBuilder), solveTopDown(a, b, m, n - 1, t, stringBuilder));

        }
        if (m == a.length() && n == b.length())
            System.out.println(stringBuilder.reverse().toString());
        return t[m][n];

    }

    public static int solveBottomUpOptimized(String a, String b) {
        if (a == null || b == null)
            return 0;
        int count = 0;
        int[][] t = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    t[i][j] = 1 + t[(i - 1)][j - 1];
                    System.out.print(a.charAt(i - 1));
                    count++;
                } else {
                    t[i][j] = Math.max(t[(i - 1)][j], t[i][j - 1]);
                }
            }
        }
        return count;
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
        printLCS(a, b, t);
        printShortestCommonSuperSeq(a, b, t);
        return t[a.length()][b.length()];
    }

    private static void printShortestCommonSuperSeq(String a, String b, int[][] t) {
        int i = a.length();
        int j = b.length();
        StringBuilder builder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                builder.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    builder.append(a.charAt(i - 1));
                    i--;
                } else {
                    builder.append(b.charAt(j - 1));
                    j--;
                }
            }
        }
        if (i != 0) {
            builder.append(new StringBuilder(a.substring(0, i + 1)).reverse().toString());
        }
        if (j != 0)
            builder.append(new StringBuilder(b.substring(0, j + 1)).reverse().toString());

        System.out.println(builder.reverse().toString());

    }

    private static void printLCS(String a, String b, int[][] t) {
        int i = a.length();
        int j = b.length();
        StringBuilder builder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                builder.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    i--;
                } else
                    j--;
            }
        }
        System.out.println(builder.reverse().toString());
    }


}