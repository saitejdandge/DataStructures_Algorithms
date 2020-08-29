package kadane;

public class MaxSubArray2D {

    public static void main(String[] args) {
        int [][]a = {

        {6,-5,-7,4,-4},
        {-9,3,-6,5,2},
        {-10,4,7,-6,3},
        {-8,9,-3,3,-7},
    };
        System.out.println(solve(a, a.length, a[0].length));

    }

    public static int solve(int a[][], int row, int col) {

        int sum = 0;

        int[] rowSum = new int[row];

        for (int l = 0; l < col; l++) {
            // flashing the running row sum
            for (int i = 0; i < rowSum.length; i++)
                rowSum[i] = 0;
            
            for (int r = l; r < col; r++) {
                // updating running row sum
                for (int i = 0; i < rowSum.length; i++)
                    rowSum[i] += a[i][r];
                // kadane of running row sum
                sum = Math.max(sum, MaxSubArray.solve(rowSum));
            }

        }
        return sum;
    }
}