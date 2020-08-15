package LCS;

public class DisntictSubSequences {

    static String a = "rabbbit";
    static String b = "rabbit";
    static int[][] t;

    public static void main(String[] args) {

        // t = new int[a.length() + 1][b.length() + 1];
        // for (int i = 0; i <= a.length(); i++) {
        // for (int j = 0; j <= b.length(); j++) {
        // t[i][j] = -1;
        // }
        // }

        // System.out.println(solve2(a.length(), b.length()));

        System.out.println(bottomUp());

    }

    public static int bottomUp() {
        int[][] t = new int[a.length() + 1][b.length() + 1];
        // init the matrix
        for (int i = 0; i <= a.length(); i++)
            t[i][0] = 1;

        for (int i = 1; i <= a.length(); i++)
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1))
                    t[i][j] = t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j] + t[i - 1][j - 1];
            }
        return t[a.length()][b.length()];
    }

    public static int solve2(int i, int j) {

        if (j == 0)
            return 1;
        if (i == 0)
            return 0;
        if (a.charAt(i - 1) != b.charAt(j - 1)) {
            t[i][j] = solve2(i - 1, j);
        } else {
            t[i][j] = solve2(i - 1, j) + solve2(i - 1, j - 1);
        }
        return t[i][j];
    }

    public static int solve(int i, int j) {

        if (j == b.length())
            return 1;
        if (i == a.length())
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            t[i][j] = solve(i + 1, j) + solve(i + 1, j + 1);
        } else {
            t[i][j] = solve(i + 1, j);
        }
        return t[i][j];

    }
}