package sliding_window.variable.smallest_subarray_with_sum_k;

public class Solution {

    public static void main(String[] args) {

        System.out.println(solve(new int[]{1, 1, 1, 1, 1, 2, 2, 3, 3, 1, 3, 2, 1, 3, 5, 4, 2, 1, 5, 8, 4, 1, 1}, 3));
    }

    public static int solve(int[] a, int target) {

        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0, end = 0;
        while (j < a.length) {
            sum += a[j];
            if (sum == target) {
                if (j - i + 1 < ans) {
                    ans = j - i + 1;
                    start = i;
                    end = j;
                }
                ans = Math.min(ans, j - i + 1);
                j++;
            } else if (sum < target) {
                j++;
            } else { //sum > target
                while (sum > target) {
                    sum -= a[i];
                    i++;
                }
                if (sum == target) {
                    if (j - i + 1 < ans) {
                        ans = j - i + 1;
                        start = i;
                        end = j;
                    }
                    ans = Math.min(ans, j - i + 1);
                }
                j++;
            }

        }
        if (ans != Integer.MAX_VALUE)
            for (int s = start; s <= end; s++)
                System.out.print(a[s] + " ");
        else
            System.out.println("No set found");

        System.out.println();
        return ans;
    }
}
