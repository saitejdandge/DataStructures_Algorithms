package strings.longest_palindrimic_substring;

public class Solution {

    public static void main(String[] args) {

        System.out.println(solve(""));
    }

    public static int solve(String input) {

        int n = input.length();
        int[][] dp = new int[n][n];

        int max = 0;
        int startAns = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (dp[i][i] >= max) {
                startAns = i;
                max = dp[i][i];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                if (dp[i][i + 1] >= max) {
                    startAns = i;
                    max = dp[i][i + 1];
                }
            }
        }


        for (int w = 3; w <= n; w++) {
            for (int i = 0; i < n - w + 1; i++) {
                int j = i + w - 1;
                if (input.charAt(i) == input.charAt(j) && dp[i + 1][j - 1] >= 1) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                    if (dp[i][j] >= max) {
                        max = dp[i][j];
                        startAns = i;
                    }
                }
            }
        }
        System.out.println(input.substring(startAns, max + startAns));

        return max;
    }
}
