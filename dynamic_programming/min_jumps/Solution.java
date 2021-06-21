package dynamic_programming.min_jumps;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        System.out.println(isPossible(new int[]{1, 1, 2, 3, 2, 1, 0, 0, 2, 2, 3}, 0));

        System.out.println(minJumps(new int[]{1, 4, 3, 1, 2, 6, 7, 6, 10}, 0, 0));

        System.out.println(minJumpsBottomUp(new int[]{1, 4, 3, 1, 2, 6, 7, 6, 10}));

    }

    public static int minJumps(int[] a, int currentIndex, int sum) {
        if (currentIndex >= a.length - 1)
            return sum;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= a[currentIndex]; i++) {
            res = Math.min(res, minJumps(a, i + currentIndex, sum + 1));
        }
        return res;
    }

    public static int minJumpsBottomUp(int[] a) {
        int[] dp = new int[a.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + a[j] >= i)
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
        return dp[a.length - 1];
    }

    public static boolean isPossible(int[] a, int currentIndex) {
        if (currentIndex >= a.length - 1)
            return true;

        for (int i = 1; i <= a[currentIndex]; i++) {
            if (isPossible(a, i + currentIndex))
                return true;
        }
        return false;
    }
}
