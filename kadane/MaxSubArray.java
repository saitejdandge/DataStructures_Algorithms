package kadane;

public class MaxSubArray {
    public static void main(String[] args) {
        int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solve(a));
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
}