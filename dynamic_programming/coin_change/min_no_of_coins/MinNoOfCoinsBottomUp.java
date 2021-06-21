package dynamic_programming.coin_change.min_no_of_coins;

import java.util.Arrays;

public class MinNoOfCoinsBottomUp {

    public static void main(String[] args) {
        System.out.println(minNumberOfCoins(new int[]{5, 3}, 20) + " min coins ways");
    }

    public static int minNumberOfCoins(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[1][j] = j / coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 2; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[coins.length][amount];

    }


}
