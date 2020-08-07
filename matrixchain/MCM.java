package matrixchain;

public class MCM {

    static int a[] = { 10, 20};

    public static void main(String[] args) {
        System.out.println(solve(1, a.length - 1));
    }

    public static int solve(int i, int j) {

        if (i >= j)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(i, k) + solve(k + 1, j) + a[i - 1] * a[k] * a[j];
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}