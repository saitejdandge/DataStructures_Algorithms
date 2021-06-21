package dynamic_programming.coin_change.min_no_of_coins;

import java.util.Arrays;

public class MinNoOfCoins {

    public static void main(String[] args) {
        System.out.println(totalNumberOfWays(new int[]{5, 3}, 20) + " min coins ways");
    }

    public static int totalNumberOfWays(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int k = 0; k <= coins.length; k++)
            Arrays.fill(dp[k], Integer.MAX_VALUE - 1);
        int ans = totalNumberOfWays(coins.length, coins, amount, 0, dp);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static int totalNumberOfWays(int i,
                                        int[] a,
                                        int sum,
                                        int coinsCount,
                                        int[][] dp) {

        if (i == 0)
            return Integer.MAX_VALUE - 1;
        if (sum == 0) {
            return coinsCount;
        }
        if (sum < 0)
            return Integer.MAX_VALUE - 1;

        if (dp[i][sum] != Integer.MAX_VALUE - 1) {
            return dp[i][sum];
        }

        int s = totalNumberOfWays(i, a, sum - a[i - 1], coinsCount + 1, dp);
        int f = totalNumberOfWays(i - 1, a, sum, coinsCount, dp);

        dp[i][sum] = Math.min(f, s);
        return dp[i][sum];
    }
}
