package dynamic_programming.kadane;

import java.util.Arrays;

public class MaxSubArray2D {

    public static void main(String[] args) {
        int[][] a = {
                {6, -5, -7, 4, -4},
                {-9, 3, -6, 5, 2},
                {-10, 4, 7, 6, 3},
                {-8, 9, -3, 3, -7},
        };
        System.out.println(solve(a, a.length, a[0].length));

    }

    public static int solve(int[][] a, int row, int col) {

        int sum = 0;

        int[] rowSum = new int[row];
        int ansLeft = 0, ansRight = 0, ansTop = 0, ansBottom = 0;
        for (int l = 0; l < col; l++) {
            // flashing the running row sum
            Arrays.fill(rowSum, 0);

            for (int r = l; r < col; r++) {
                // updating running row sum
                for (int i = 0; i < rowSum.length; i++)
                    rowSum[i] += a[i][r];
                // kadane of running row sum
                int[] rowMaxSumRanges = MaxSubArray.solve(rowSum);
                int rowMaxSumValue = getSum(rowSum, rowMaxSumRanges);
                if (rowMaxSumValue > sum) {
                    ansTop = rowMaxSumRanges[0];
                    ansBottom = rowMaxSumRanges[1];
                    ansLeft = l;
                    ansRight = r;
                }
                sum = Math.max(sum, rowMaxSumValue);
            }

        }
        System.out.println("Max SubArray is");
        for (int i = ansTop; i <= ansBottom; i++) {
            for (int j = ansLeft; j <= ansRight; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return sum;
    }

    private static int getSum(int[] a, int[] range) {
        int left = range[0];
        int right = range[1];
        int sum = 0;
        for (int k = left; k <= right; k++)
            sum += a[k];
        return sum;
    }
}