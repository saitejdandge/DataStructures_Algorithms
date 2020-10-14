package dynamic_programming.kadane;

public class MaxSubArray {
    public static void main(String[] args) {
        int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(solve(a));
        solveNaive(a);
    }

    public static int solve(int a[]) {

        if (a == null || a.length == 0)
            return 0;

        int output;
        int currSum;
        output = currSum = a[0];
        for (int i = 1; i < a.length; i++) {
            currSum = Math.max(a[i], currSum + a[i]);
            output = Math.max(output, currSum);
        }
        return output;
    }

    public static int solveNaive(int a[]) {
        int n = a.length;
        for (int start = 0; start <= n - 1; start++)
            for (int l = start; l < n; l++) {
                for (int r = 0; r <= l; r++) {
                    System.out.print(a[r] + " ");
                }
                System.out.println();
            }
        return -1;
    }
}