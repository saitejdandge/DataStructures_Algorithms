package edit_distance;

public class Solution {

    public static void main(String[] args) {
        System.out.println(minDistance("saitej", "tej"));
    }

    public static int minDistance(String A, String B) {
        int t[][] = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++)
            for (int j = 0; j <= B.length(); j++)
                t[i][j] = -1;
        return solve(A, B, A.length(), B.length(), t);

    }

    public static int solve(String a, String b, int m, int n, int t[][]) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (t[m][n] != -1)
            return t[m][n];
        if (a.charAt(m - 1) == b.charAt(n - 1))
            t[m][n] = solve(a, b, m - 1, n - 1, t);
        else {
            int k1;
            int k2;
            int k3;

            if (t[m - 1][n] == -1)
                t[m - 1][n] = solve(a, b, m - 1, n, t);
            k1 = t[m - 1][n];

            if (t[m - 1][n - 1] == -1)
                t[m - 1][n - 1] = solve(a, b, m - 1, n - 1, t);

            k2 = t[m - 1][n - 1];

            if (t[m][n - 1] == -1)
                t[m][n - 1] = solve(a, b, m, n - 1, t);

            k3 = t[m][n - 1];

            t[m][n] = Math.min(Math.min(k2, k3), k1) + 1;
        }
        return t[m][n];
    }
}
