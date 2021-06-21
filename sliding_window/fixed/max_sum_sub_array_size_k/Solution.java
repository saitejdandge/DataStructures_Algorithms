package sliding_window.fixed.max_sum_sub_array_size_k;

public class Solution {
    public static void main(String[] args) {

        int[] a = new int[]{12222, 2, 3, 1, 2, 2, 2, 1, 3, 3, 5, 3, 1, 3, 5, 3, 2, 35, 6, 5, 4, 22, 2, 2};
        System.out.println("Max " + maxSubArraySum(a, 3
        ));

    }

    public static int maxSubArraySum(int[] a, int windowSize) {
        if (a.length < windowSize)
            return 0;
        int i = 0, j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int resi = 0, resj = 0;
        while (j < a.length) {
            sum += a[j];
            if (j - i + 1 >= windowSize) {
                if (sum >= max) {
                    max = sum;
                    resi = i;
                    resj = j;
                }
                sum -= a[i];
                i++;
            }
            j++;
        }
        for (int k = resi; k <= resj; k++)
            System.out.print(a[k] + " ");
        return max;
    }
}
