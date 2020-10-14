package dynamic_programming. subsetsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    static int[] data = {  1, 1, 1, 1, 4, 2, 6 };

    public static void main(String[] args) {
        // System.out.println(solve(data.length, 6));
        int[][] t = new int[data.length + 1][6 + 1];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
        ArrayList<Integer> v = new ArrayList<>();
        // System.out.println("Top Down" + topDown(data.length, 6, t, v));
        System.out.println(largestSubSetSum(data.length, 6));
    }

    public static int largestSubSetSum(int n, int sum) {
        if (sum == 0 || n == 0)
            return 0;
        if (data[n - 1] <= sum) {
            return Math.max(largestSubSetSum(n - 1, sum - data[n - 1]) + 1, largestSubSetSum(n - 1, sum));
        } else {
            return largestSubSetSum(n - 1, sum);
        }
    }

    public static int solve(int n, int sum) {

        if (n == 0 && sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (sum == 0)
            return 1;
        if (data[n - 1] <= sum) {
            return (solve(n - 1, sum - data[n - 1]) + solve(n - 1, sum));
        } else
            return solve(n - 1, sum);
    }

    /*
     * isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0 isSubsetSum(set, n,
     * sum) = true, if sum == 0
     */

    public static int topDown(int n, int sum, int[][] t, List<Integer> list) {

        if (sum < 0)
            return -1;
        if (sum == 0) {
            System.out.println("------------");
            for (int x : list)
                System.out.print(x + " ");
            System.out.println();
            System.out.println("------------");

            return 1;
        }
        if (n == 0)
            return 0;

        if (t[n][sum] != -1)
            return t[n][sum];

        if (data[n - 1] <= sum) {
            list.add(data[n - 1]);
            int inclusive = topDown(n - 1, sum - data[n - 1], t, list);
            list.remove(new Integer(data[n - 1]));
            int exclusive = topDown(n - 1, sum, t, list);
            t[n][sum] = inclusive + exclusive;
        } else {
            t[n][sum] = topDown(n - 1, sum, t, list);
        }

        return t[n][sum];
    }

}