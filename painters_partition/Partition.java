package painters_partition;

public class Partition {
    static int a[] = { 10, 30, 60, 10, 40 };

    public static void main(String[] args) {
        System.out.println(solve(0, a.length - 1, 4));
    }

    public static int solve(int i, int j, int p) {

        if (i > j)
            return 0;
        if (i == j)
            return a[i];
        if (p == 0) {
            int s = 0;
            for (int k = i; k <= j; k++)
                s += a[i];
            return s;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = solve(i, k, p - 1);
            int right = solve(k + 1, j, p - 1);
            int temp = Math.max(left, right);
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}
