package backtracking.k_buckets_equal_sum;

public class Solution {

    public static void main(String[] args) {

        int[] a = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(driver(a, 4));

    }

    public static boolean driver(int[] a, int k) {

        if (k == 0)
            return false;
        int sum = 0;
        for (int i : a)
            sum += i;

        if (sum % k != 0 || sum == 0)
            return false;

        int n = a.length;
        boolean[] output = new boolean[n];
        return solve(k, 0, output, 0, 0, a);
    }

    public static boolean solve(int k, int l, boolean[] output, int progress, int total, int a[]) {
        if (k == 1) {
            return true;
        }

        if (progress == total)
            return solve(k - 1, 0, output, 0, total, a);

        for (int i = l; i <= output.length; i++) {
            if (!output[i] && a[i] <= total - progress) {
                output[i] = true;
                if (solve(k, i + 1, output, progress + a[i], total, a))
                    return true;
                output[i] = false;
            }
        }
        return false;
    }

}
