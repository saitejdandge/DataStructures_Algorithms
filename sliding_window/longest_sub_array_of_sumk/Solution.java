package sliding_window.longest_sub_array_of_sumk;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, 0));
    }

    public static int solve(int[] a, int sum) {
        int count = 0;
        int i = 0, j = 0;
        int currentSum = 0;
        while (j < a.length) {
            currentSum += a[j];
            if (currentSum < sum) {
                j++;
            } else if (currentSum == sum) {
                System.out.print("Candidate ");
                for (int k = i; k <= j; k++)
                    System.out.print(a[k] + " ");
                System.out.println();
                count = Math.max(count, j - i + 1);
                j++;
            } //currentSum crossed the sum
            else {
                while (currentSum > sum) {
                    currentSum -= a[i];
                    i++;
                }
                if (currentSum == sum) {
                    count = Math.max(count, j - i + 1);
                }
                j++;
            }
        }
        return count;
    }
}
