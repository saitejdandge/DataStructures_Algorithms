package dynamic_programming.LCS;

public class LongestNonDecreasing {

    static int a[] = { -1, 3, 4, 5, 2, 2, 2, 2 };

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        int dp[] = new int[a.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;

        int n = a.length;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i < j; i++) {
                if (a[j - 1] >= a[i - 1]) {
                    dp[j - 1] = Math.max(dp[j - 1], 1 + dp[i - 1]);
                    // System.out.print(a[j - 1] + " ");
                }
            }
        }
        return dp[n - 1];

    }

}
