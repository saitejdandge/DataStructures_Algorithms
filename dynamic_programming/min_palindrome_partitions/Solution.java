package dynamic_programming.min_palindrome_partitions;

public class Solution {
    public static void main(String[] args) {

        System.out.println(solve("nitik".toCharArray()));
    }

    public static int solve(char[] a) {

        int n = a.length;

        Obj[][] dp = new Obj[n][n];

        /*Initialization*/
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = new Obj();
            }
        }

        /*Window of size 1*/
        for (int i = 0; i < n; i++) {
            dp[i][i].minNoOfPartitions = 0;
            dp[i][i].isPalindrome = true;
        }

        /*Window of size 2*/
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                dp[i][i + 1].minNoOfPartitions = 1;
            } else {
                dp[i][i + 1].minNoOfPartitions = 0;
                dp[i][i + 1].isPalindrome = true;
            }
        }

        /*Window of size [3..n] */
        for (int w = 3; w <= n; w++) {
            for (int start = 0; start < n - w + 1; start++) {
                int end = start + w - 1;
                //[start,end] is my range
                //check for palindrome
                if (a[start] == a[end] && dp[start + 1][end - 1].isPalindrome) {
                    dp[start][end].isPalindrome = true;
                    dp[start][end].minNoOfPartitions = 0;
                } else {
                    int ans = Integer.MAX_VALUE;
                    for (int k = start; k < end; k++) {
                        ans = Math.min(ans, dp[start][k].minNoOfPartitions + dp[k + 1][end].minNoOfPartitions);
                    }
                    dp[start][end].minNoOfPartitions = ans + 1;
                }


            }
        }
        return dp[0][a.length - 1].minNoOfPartitions;
    }

    static class Obj {
        int minNoOfPartitions;
        boolean isPalindrome;

        public Obj() {
            this.minNoOfPartitions = 0;
            this.isPalindrome = false;
        }
    }
}
