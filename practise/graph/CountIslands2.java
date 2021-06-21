package practise.graph;

public class CountIslands2 {

    public static void main(String[] args) {

        int count = 0;
        int[][] a = {{1, 1, 1}, {0, 0, 0}, {1, 1, 1}};
        int[][] dp = {{1, 1, 1}, {0, 0, 0}, {1, 1, 1}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1 && dp[i][j] == 1) {
                    count++;
                    System.out.println("[" + i + "," + j + "] " + countIslands(a, i, j, dp));
                }
            }
        }
        System.out.println(count);
    }

    public static int countIslands(int[][] a, int i, int j, int[][] dp) {
        //invalid bounds or wall return
        if (i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] == 0 || dp[i][j] == 2)
            return 0;

        dp[i][j] = 2;
        int p = countIslands(a, i + 1, j, dp);
        int q = countIslands(a, i - 1, j, dp);
        int r = countIslands(a, i, j + 1, dp);
        int s = countIslands(a, i, j - 1, dp);
        return 1 + p + q + r + s;
    }
}
