package subsetsum;

import java.util.Arrays;

public class SubsetSum {
    static int[] data = { 1,2,3,4,5,6 };

    public static void main(String[] args) {
        System.out.println(solve(data.length, 6));
        int[][] t = new int[data.length + 1][6 + 1];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
        System.out.println("Top Down" + topDown(data.length, 6, t));
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
    isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
    isSubsetSum(set, n, sum) = true, if sum == 0 
    */

    public static int topDown(int n, int sum, int[][] t) {
        if (n == 0 && sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (sum == 0)
            return 1;

        if (t[n][sum] != -1)
            return t[n][sum];

        if (data[n - 1] <= sum) {
            t[n][sum] = topDown(n - 1, sum - data[n - 1], t) + topDown(n - 1, sum, t);
        } else {
            t[n][sum] = topDown(n - 1, sum, t);
        }

        return t[n][sum];
    }

    public static void printElements(int n, int sum, int[][] t) {
        int res = t[n][sum];
        for (int i = n; i > 0 && sum > 0; i--) {
            if (t[i - 1][sum] != res) {
                System.out.print(data[i - 1] + "@Element");
                sum -= data[i - 1];
                res--;
            }
        }

    }

}