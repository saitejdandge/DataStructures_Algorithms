package practise.graph;

public class CountIslands {

    public static void main(String[] args) {

        int count = 0;
        int[][] a = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] dp = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1 && dp[i][j] == 1) {
                    count++;
                    countIslands(a, i, j, dp);
                }
            }
        }
        System.out.println(count);
    }

    public static void countIslands(int[][] a, int i, int j, int[][] dp) {
        //invalid bounds or wall return
        if (i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] == 0 || dp[i][j] == 2)
            return;

        dp[i][j] = 2;
        countIslands(a, i + 1, j, dp);
        countIslands(a, i - 1, j, dp);
        countIslands(a, i, j + 1, dp);
        countIslands(a, i, j - 1, dp);
    }
}
