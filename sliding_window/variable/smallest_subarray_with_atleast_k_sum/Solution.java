package sliding_window.variable.smallest_subarray_with_atleast_k_sum;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 4, 5, 6, 100000, 3, 4, 1, 1, 1, 1, 3, 2}, 7));
    }

    public static int solve(int[] a, int target) {

        int i = 0, j = 0, n = a.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (j < n) {
            sum += a[j];
            if (sum < target)
                j++;
            else {
                while (i <= j && sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    sum -= a[i];
                    i++;
                }
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
