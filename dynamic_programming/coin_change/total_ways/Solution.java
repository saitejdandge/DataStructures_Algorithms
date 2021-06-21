package dynamic_programming.coin_change.total_ways;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(totalNumberOfWays(new int[]{1, 2, 3}, 5) + " are ways");
        recursive(0, 0, new StringBuilder(), new int[]{1, 2, 3}, 5);
    }

    public static int totalNumberOfWays(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int k = 0; k <= coins.length; k++)
            Arrays.fill(dp[k], -1);
        int ans = totalNumberOfWays(coins.length, coins, amount, 0, dp);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static int totalNumberOfWays(int i,
                                        int[] a,
                                        int sum,
                                        int coinsCount,
                                        int[][] dp) {
        if (i == 0)
            return 0;
        if (sum == 0) {
            return 1;
        }
        if (sum < 0)
            return 0;

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int s = totalNumberOfWays(i, a, sum - a[i - 1], coinsCount + 1, dp);
        int f = totalNumberOfWays(i - 1, a, sum, coinsCount, dp);

        dp[i][sum] = f + s;
        return dp[i][sum];
    }


    public static void recursive(int i, int sum, StringBuilder output, int[] coins, int amount) {

        if (i == coins.length) {
            if (sum == amount) {
                System.out.println(output.toString());
                System.out.println();
            }
            return;
        }

        for (int j = amount / coins[i]; j >= 0; j--) {
            recursive(i + 1, sum + (coins[i] * j),
                    output.append(coins[i])
                            .append("X")
                            .append(j)
                            .append(" "), coins, amount);
        }
//        recursive(i + 1, sum, output, coins, amount);
    }
}
