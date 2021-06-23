package amazon.Choclate.open_close_windows;

public class Solution {

    public static void main(String[] args) {

        String input = "xx|xx|x|";
        Obj[][] dp = solve(input.toCharArray());
        for (int l = 0; l < input.length(); l++)
            for (int r = l; r < input.length(); r++) {
                System.out.println(input.substring(l, r + 1) + " " + dp[l][r].ans);
            }
    }

    public static Obj[][] solve(char[] input) {

        int n = input.length;
        Obj[][] dp = new Obj[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = new Obj(input[i] == 'x' ? 1 : 0, 0);
        }
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            if (input[i] == 'x')
                count++;
            if (input[i + 1] == 'x')
                count++;
            dp[i][i + 1] = new Obj(count, 0);
        }

        for (int w = 3; w <= n; w++) {
            for (int start = 0; start < n - w + 1; start++) {
                int end = start + w - 1;
                //[start,end] is current substring

                if (input[start] == '|' && input[end] == '|') {
                    dp[start][end] = new Obj(dp[start + 1][end - 1].xCount, dp[start + 1][end - 1].xCount);
                } else {
                    int ansval = Math.max(Math.max(dp[start][end - 1].ans, dp[start + 1][end - 1].ans), dp[start + 1][end].ans);
                    int xCount = dp[start + 1][end].xCount;
                    if (input[start] == 'x')
                        xCount += 1;
                    dp[start][end] = new Obj(xCount, ansval);

                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != null)
                    System.out.print(dp[i][j].ans + "\t");
                else
                    System.out.print("_\t");
            }
            System.out.println();
        }


        return dp;
    }


    static class Obj {
        int xCount;
        int ans;

        public Obj(int xCount, int ans) {
            this.xCount = xCount;
            this.ans = ans;
        }
    }
}
