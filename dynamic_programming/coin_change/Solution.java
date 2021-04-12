package dynamic_programming.coin_change;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,3,4,5,6}, 10));
    }

    public static int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++)
            for (int j = 0; j <= amount; j++)
                dp[i][j] = -1;

        int ans = solve(coins.length, coins, amount, 0, dp, new ArrayList<>());
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static int solve(int i, int[] a, int sum, int coinsCount, int[][] dp, List<Integer> coins) {
        if (sum == 0) {
            System.out.println(coins);
            return 1;
        }
        if (sum < 0 || i == 0)
            return 0;

//        if (dp[i][sum] != -1)
//            return dp[i][sum];

        coins.add(new Integer(a[i - 1]));
//        System.out.println("Including " + a[i - 1]);
        int s = solve(i, a, sum - a[i - 1], coinsCount + 1, dp, coins);
        coins.remove(new Integer(a[i - 1]));
//        System.out.println("Excluding " + a[i - 1]);
        int f = solve(i - 1, a, sum, coinsCount, dp, coins);
        dp[i][sum] = f + s;
        return dp[i][sum];
    }
}
