package dynamic_programming.kadane;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] range = solve(a);
        System.out.println(range[0] + " index to " + range[1]);
    }

    public static int[] solve(int[] a) {

        if (a == null || a.length == 0)
            return null;
        int output;
        int currSum;
        output = currSum = a[0];
        int left = 0, right = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > currSum + a[i]) {
                left = right = i;
            }
            currSum = Math.max(a[i], currSum + a[i]);
            if (currSum > output) {
                right = i;
            }
            output = Math.max(output, currSum);
        }
        return new int[]{left, right};
    }


    public static int solveNaive(int[] a) {
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