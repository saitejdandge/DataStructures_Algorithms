package dynamic_programming.unbounded_ks;

public class MinCoins {
    static int data[];

    public static void main(String[] args) {
        data = new int[3];
        data[0] = 18;
        data[1] = 5;
        data[2] = 2;

        System.out.println(solve(data.length, 30));
        System.out.println(bottomUp(data.length, 30));
    }

    public static int solve(int n, int sum) {
        if (n == 0)
            return Integer.MAX_VALUE - 1;
        if (sum == 0)
            return 0;
        if (data[n - 1] <= sum) {
            return Math.min(1 + solve(n, sum - data[n - 1]), solve(n - 1, sum));
        }
        return solve(n - 1, sum);
    }

    public static int bottomUp(int n, int sum) {
        int t[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++)
            t[0][i] = Integer.MAX_VALUE - 1;

        // initializing base case
        for (int i = 1; i <= sum; i++) {
            if (i % data[0] == 0)
                t[1][i] = i / data[0];
            else
                t[1][i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (data[i - 1] <= j) {
                    t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - data[i - 1]]);
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }
}
