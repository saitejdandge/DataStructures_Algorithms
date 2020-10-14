package dynamic_programming.dungeon;

class Solution {
    public int calculateMinimumHP(int[][] a) {

        if (a == null)
            return 0;
        int rows = a.length;
        int cols = a[0].length;
        int dp[][] = new int[rows][cols];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {

                if (i == rows - 1 && j == cols - 1)
                    dp[i][j] = Math.min(0, a[i][j]);
                else if (i == rows - 1) {
                    dp[i][j] = Math.min(0, a[i][j] + dp[i][j + 1]);
                } else if (j == cols - 1) {
                    dp[i][j] = Math.min(0, a[i][j] + dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.min(0, a[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }
        return Math.abs(dp[0][0]) + 1;

    }
}
