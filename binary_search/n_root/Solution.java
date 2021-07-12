package binary_search.n_root;

public class Solution {

    public static void main(String[] args) {

        int n = 8;
        double ans = nRoot(100, n, 5);
        System.out.println(ans);
        System.out.println(multiply(ans, n));
    }

    public static double nRoot(double target, int n, int precision) {
        double low = 1;
        double precisionDiff = Math.pow(10, -1 * precision);
        double high = target;
        while (high - low > precisionDiff) {
            double mid = low + ((high - low) / 2.0);
            if (multiply(mid, n) < target)
                low = mid;
            else
                high = mid;
        }
        return low;

    }

    private static double multiply(double mid, int n) {
        double ans = 1;
        for (int i = 1; i <= n; i++)
            ans *= mid;
        return ans;
    }
}
